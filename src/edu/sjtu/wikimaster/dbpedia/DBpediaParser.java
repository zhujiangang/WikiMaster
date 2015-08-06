package edu.sjtu.wikimaster.dbpedia;

import java.io.BufferedWriter;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jcommons.common.CommonUtils;
import org.jcommons.common.StringUtils;
import org.jcommons.file.FileUtils;
import org.jcommons.file.ILineHandler;

public class DBpediaParser {

	public static void main(String[] args) {
		File pageLinkTTL = new File("C:/Research/EL/data/page_links_en.ttl");
		File outlink = new File("C:/Research/EL/data/outlink_dbpedia");
		File nameId = new File("C:/Research/EL/data/nameid_dbpedia");

		DBpediaParser parser = new DBpediaParser();
		parser.parsePageLinks(pageLinkTTL, outlink, nameId);
		
//		String uri = "<http://dbpedia.org/resource/Computer_accessibility> .";
//		String namespace = "http://dbpedia.org/resource";
//		System.out.println(extract(uri, namespace));
	}

	public void parsePageLinks(File pageLinkTTL, File outlink, File nameId) {
		final Map<String, Integer> nameIdMap = new HashMap<String, Integer>();
		final int[] cnt = { 0 };
		final Map<Integer, Set<Integer>> outlinkMap = new HashMap<Integer, Set<Integer>>();
		System.out.print("正在解析...");
		long start = System.currentTimeMillis();
		FileUtils.readLine(pageLinkTTL, new ILineHandler() {

			// <http://dbpedia.org/resource/AccessibleComputing>
			// <http://dbpedia.org/ontology/wikiPageWikiLink>
			// <http://dbpedia.org/resource/Computer_accessibility> .
			@Override
			public void process(String line) throws Exception {
				// TODO Auto-generated method stub
				if (line.startsWith("#"))
					return;
				System.out.println(cnt[0]);
				String[] arr = line
						.split("<http://dbpedia.org/ontology/wikiPageWikiLink>");
				String namespace = "http://dbpedia.org/resource/";
				String from = extract(arr[0], namespace);
				String to = extract(arr[1], namespace);
				Integer fromId, toId;
				if (nameIdMap.containsKey(from))
					fromId = nameIdMap.get(from);
				else {
					fromId = cnt[0];
					nameIdMap.put(from, fromId);
					cnt[0]++;
				}
				if (nameIdMap.containsKey(to))
					toId = nameIdMap.get(to);
				else {
					toId = cnt[0];
					nameIdMap.put(to, toId);
					cnt[0]++;
				}
				CommonUtils.addToMap(outlinkMap, fromId, toId);
			}
		});
		long end = System.currentTimeMillis();
		long time = (end - start) / 1000;
		System.out.println("[" + time + "s]");
		System.out.print("正在写入...");
		start = System.currentTimeMillis();
		BufferedWriter writer1 = FileUtils.getBufferedWriter(outlink);
		BufferedWriter writer2 = FileUtils.getBufferedWriter(nameId);
		try {
			for (Map.Entry<Integer, Set<Integer>> entry : outlinkMap.entrySet()) {
				writer1.write(entry.getKey() + ":"
						+ CommonUtils.set2Str(entry.getValue(), ",") + "\n");
			}

			for (Map.Entry<String, Integer> entry : nameIdMap.entrySet()) {
				writer2.write(entry.getKey() + "-_-" + entry.getValue() + "\n");
			}
		} catch (Exception e) {

		} finally {
			FileUtils.closeWriter(writer1);
			FileUtils.closeWriter(writer2);
		}
		end = System.currentTimeMillis();
		time = (end - start) / 1000;
		System.out.println("[" + time + "s]");
	}
	
	public static String extract(String uri,String namespace){
		if(StringUtils.isBlank(namespace))
			return uri;
		uri = uri.trim();
		if(uri.startsWith("<"))
			uri = uri.substring(1);
		if(uri.endsWith(">"))
			uri = uri.substring(0,uri.length()-1);
		else if(uri.endsWith("> ."))
			uri = uri.substring(0,uri.length()-3);
		if(!namespace.endsWith("/"))
			namespace += "/";
		return uri.substring(namespace.length(),uri.length());
	}
}
