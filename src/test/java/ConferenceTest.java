import Exceptions.BadDataFormatException;
import model.Conference;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by callummarriage on 20/03/2018.
 */
public class ConferenceTest {

    @Test(expected = BadDataFormatException.class)
    public void constructorBadFormatTest() throws IOException, BadDataFormatException {
        Conference conferenceBadFormat = new Conference();
        conferenceBadFormat.readFile("./src/test/resources/Bad-Format-Seminar.txt");
    }

    @Test(expected = BadDataFormatException.class)
    public void constructorBadNameTest() throws IOException, BadDataFormatException {
        Conference conferenceBadName = new Conference();
        conferenceBadName.readFile("./src/test/resources/Bad-Name-Seminar.txt");

    }

    @Test
    public void constructorGoodFileTest() throws IOException, BadDataFormatException {
        Conference conferenceGoodFile = new Conference();
        conferenceGoodFile.readFile("./src/test/resources/Good-File-Seminar.txt");
    }


    @Test
    public void splitContentType(){
        Conference conference = new Conference();
        String content = "This is the content.";
        String content2 = "This is the content. With two sentences";
        String content3 = "This is the content. With three sentences. Third one.";
        String[] results = conference.getContentSplitIntoSections(content, 2);
        assertEquals("This is the content.", results[0]);
        assertEquals("I have nothing to say!", results[1]);

        String[] results2 = conference.getContentSplitIntoSections(content2, 2);
        assertEquals("This is the content.", results2[0]);
        assertEquals(" With two sentences.", results2[1]);

        String[] results3 = conference.getContentSplitIntoSections(content3, 3);
        assertEquals("This is the content.", results3[0]);
        assertEquals(" With three sentences.", results3[1]);
        assertEquals(" Third one.", results3[2]);

    }

}
