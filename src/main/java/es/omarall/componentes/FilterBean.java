package es.omarall.componentes;

import org.apache.camel.Body;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.sun.syndication.feed.synd.SyndCategory;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;

@Component
public class FilterBean {

	@Value("${emt.bus.line.number}")
	private String lineNumber;

	public boolean filtraPorLinea(@Body SyndFeed feed) {
		SyndEntry firstEntry = (SyndEntry) feed.getEntries().get(0);
		return firstEntry.getCategories().stream().anyMatch(c -> ((SyndCategory) c).getName().equals(lineNumber));
	}

}
