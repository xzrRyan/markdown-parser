import static org.junit.Assert.*;
import org.junit.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class MarkdownParseTest{
    @Test
    public void addition() throws IOException {
        assertEquals(2, 1 + 1);



        Path fileName = Path.of("test-file.md");
        String content = Files.readString(fileName);
        // String[] b = {"https://something.com", "some-thing.html"};
        ArrayList<String> a = MarkdownParse.getLinks(content);
        ArrayList<String> links = new ArrayList<>(List.of("https://something.com", "some-thing.html"));
        assertEquals(links, a);

        assertFalse(links.equals(a));


    }
}


