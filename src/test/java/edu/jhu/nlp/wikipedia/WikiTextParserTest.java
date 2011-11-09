package edu.jhu.nlp.wikipedia;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class WikiTextParserTest
{
    private BufferedReader in = null;
    private String wtext = null;

    @Before
    public void setup() throws IOException
    {
        in = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/Lexington.wiki")));

        StringBuilder sb = new StringBuilder();
        String line = null;
        while((line = in.readLine()) != null) {
            sb.append(line);
            sb.append('\n');
        }
        wtext = sb.toString();
    }

    @After
    public void teardown() throws IOException
    {
        if (in != null) {
            in.close();
        }
        in = null;
    }

    @Test
    public void testDisambiguationPage() throws IOException
    {
        WikiTextParser wtp = new WikiTextParser(wtext);
        assertTrue(wtp.isDisambiguationPage());
    }

    // TODO: create more test cases since there really isn't any in the
    // original code.
}
