package es.omarall.componentes;

import org.springframework.stereotype.Component;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;

@Component
public class FeedProcessor {
	public String processFeed(SyndFeed feed) {

		SyndEntry firstEntry = (SyndEntry) feed.getEntries().get(0);

		String description = firstEntry.getDescription().getValue();
		String link = firstEntry.getLink();

		return String.format("*%s*\n%s\n<%s>", firstEntry.getTitle(), description, link);
	}
}
