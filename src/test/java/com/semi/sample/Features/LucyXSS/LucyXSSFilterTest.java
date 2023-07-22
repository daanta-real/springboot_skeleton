package com.semi.sample.Features.LucyXSS;

import com.nhncorp.lucy.security.xss.XssFilter;
import com.nhncorp.lucy.security.xss.XssPreventer;
import com.nhncorp.lucy.security.xss.XssSaxFilter;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Traditional Lucy XSS Filter usage practice
 */
@Slf4j
public class LucyXSSFilterTest {

    /**
     * To handle just simple text, just use "XssPreventer".
     * 1) .escape(): Escape all HTML chars for preventing applying HTML
     * 2) .unescape(): Make all HTML chars for applying HTML
     */
    @Test
    public void testXssPreventer() {
        String dirty = "\"><script>alert('xss');</script>";
        String clean = XssPreventer.escape(dirty);

        assertEquals(clean, "&quot;&gt;&lt;script&gt;alert(&#39;xss&#39;);&lt;/script&gt;");
        assertEquals(dirty, XssPreventer.unescape(clean));
    }

    /**
     * To handle the complex HTML String, use "XssFilter".
     * XssFilter can handle two types: DOM(parse after whole xml has been loaded), SAX(parse line by line)
     */

    // 1) DOM
    @Test
    public void pairQuoteCheckOtherCase() {
        XssFilter filter = XssFilter.getInstance("lucy-xss-superset.xml");
        String dirty = "<img src=\"<img src=1\\ onerror=alert(1234)>\" onerror=\"alert('XSS')\">";
        String expected = "<img src=\"\"><!-- Not Allowed Attribute Filtered ( onerror=alert(1234)) --><img src=1\\>\" onerror=\"alert('XSS')\"&gt;";
        String actual = filter.doFilter(dirty);
        assertEquals(expected, actual);

        dirty = "<img src='<img src=1\\ onerror=alert(1234)>\" onerror=\"alert('XSS')\">";
        expected = "<img src=''><!-- Not Allowed Attribute Filtered ( onerror=alert(1234)) --><img src=1\\>\" onerror=\"alert('XSS')\"&gt;";
        actual = filter.doFilter(dirty);
        assertEquals(expected, actual);
    }

    /**
     * 2) SAX = XssSaxFilter
     * Get an instance and use .doFilter()
     */
    @Test
    public void testSuperSetFix() {
        XssSaxFilter filter = XssSaxFilter.getInstance("lucy-xss-superset-sax.xml");
        String dirty = "<img src=\"<img src=1\\ onerror=alert(1234)>\" onerror=\"alert('XSS')\">";
        String expected = "<TABLE class=\"Naver_Layout_Main\" style=\"TABLE-LAYOUT: fixed\" cellSpacing=\"0\" cellPadding=\"0\" width=\"743\">" + "</TABLE>" + "<SPAN style=\"COLOR: #66cc99\"></SPAN>";
        String actual = filter.doFilter(dirty);
        assertEquals(expected, actual);
    }

}
