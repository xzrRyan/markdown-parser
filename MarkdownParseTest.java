import static org.junit.Assert.*;
import org.junit.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class MarkdownParseTest{
    @Test
    public void test1() throws IOException {
        assertEquals(2, 1 + 1);



        Path fileName = Path.of("test-file.md");
        String content = Files.readString(fileName);
        // String[] b = {"https://something.com", "some-thing.html"};
        ArrayList<String> a = MarkdownParse.getLinks(content);
        ArrayList<String> links = new ArrayList<>(List.of("https://something.com", "some-thing.html"));
        assertEquals(links, a);

        assertTrue(links.equals(a));
        

    }
    @Test
    public void test2() throws IOException {
        Path fileName = Path.of("test-file5.md");
        String content = Files.readString(fileName); 
        ArrayList<String> a = MarkdownParse.getLinks(content);
        ArrayList<String> links = new ArrayList<>(List.of("www.google.com"));
        assertEquals(links, a);

    }

    @Test
    public void snippet1() throws IOException {
        Path fileName = Path.of("Snippet1.md");
        String content = Files.readString(fileName); 
        ArrayList<String> a = MarkdownParse.getLinks(content);
        ArrayList<String> links = new ArrayList<>(List.of("`google.com, google.com, ucsd.edu"));
        assertEquals(links, a);
    }

    @Test
    public void snippet2() throws IOException {
        Path fileName = Path.of("Snippet2.md");
        String content = Files.readString(fileName); 
        ArrayList<String> a = MarkdownParse.getLinks(content);
        ArrayList<String> links = new ArrayList<>(List.of("a.com, a.com(()), example.com"));
        assertEquals(links, a);
    }

    @Test
    public void snippet3() throws IOException {
        Path fileName = Path.of("Snippet3.md");
        String content = Files.readString(fileName); 
        ArrayList<String> a = MarkdownParse.getLinks(content);
        ArrayList<String> links = 
        new ArrayList<>(List.of("https://www.twitter.com,"
        +" https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule, https://cse.ucsd.edu/"));
        assertEquals(links, a);
    }
}


