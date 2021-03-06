package edu.sjtu.wikimaster;

import java.io.IOException;

import org.jcommons.common.StringUtils;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import edu.sjtu.wikimaster.model.Article;
import edu.sjtu.wikimaster.model.Contributor;
import edu.sjtu.wikimaster.model.Revision;

public class WikipediaParser extends DefaultHandler {
	private String preTag;
	private Article article;
	private Revision revision;
	private Contributor contributor;

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		super.startElement(uri, localName, qName, attributes);
		if ("page".equals(qName)) {
			article = new Article();
		} else if ("revision".equals(qName)) {
			revision = new Revision();
		} else if ("contributor".equals(qName)) {
			contributor = new Contributor();
		}
		preTag = qName;
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		// TODO Auto-generated method stub
		String content = new String(ch, start, length);
		if ("title".equals(preTag)) {
			article.setTitle(content);
			// System.out.println(article.getTitle());
		} else if ("id".equals(preTag)) {
			if (contributor != null && StringUtils.isBlank(contributor.getId()))
				contributor.setId(content);
			else if (revision != null && StringUtils.isBlank(revision.getId()))
				revision.setId(content);
			else if (article != null && StringUtils.isBlank(article.getId()))
				article.setId(content);
		} else if ("text".equals(preTag)) {
			if (revision != null && StringUtils.isBlank(revision.getText())) {
				revision.setText(content);
				parseContent(article, content);
			}
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		// TODO Auto-generated method stub
		super.endElement(uri, localName, qName);
		if ("page".equals(qName)) {
			// store
			article = null;
			revision = null;
		} else if ("revision".equals(qName)) {
			Revision r = revision.copy();
			article.setRevision(r);
			revision = null;
		} else if ("contributor".equals(qName)) {
			Contributor c = contributor.copy();
			revision.setContributor(c);
			contributor = null;
		}
		preTag = null;
	}

	private void parseContent(Article article, String content) {

	}
}
