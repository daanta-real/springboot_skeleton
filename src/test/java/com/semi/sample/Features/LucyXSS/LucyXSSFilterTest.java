package com.semi.sample.Features.LucyXSS;

import com.nhncorp.lucy.security.xss.XssFilter;
import com.nhncorp.lucy.security.xss.XssPreventer;
import com.nhncorp.lucy.security.xss.XssSaxFilter;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Traditional Lucy XSS Filter usage practice
 * Manual from: <a href="http://naver.github.io/lucy-xss-filter/kr/">...</a>
 */
@Slf4j
public class LucyXSSFilterTest {

    /**
     * [1] PREVENTING ANY HTML
     * To totally prevent any HTML, just use "XssPreventer".
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
     * [2] ACCEPTS HTML BUT FILTER IT
     * To handle the complex HTML String in the situation it is allowed
     * but just want to prevent XSS attack, use "XssFilter".
     * XssFilter can handle two types: DOM(parse after whole xml has been loaded), SAX(parse line by line)
     * Before using any of these, you must make "lucy-xss-superset-sax.xml" file at the classpath root directory.
     * <p>
     * 1) DOM
     * String result = XssFilter.getInstance.doFilter(originalString)
     * Before using, you must make "lucy-xss.xml" file at the classpath root directory.
     */
    @Test
    public void pairQuoteCheckOtherCase() {
        XssFilter filter = XssFilter.getInstance("lucy-xss-superset.xml");
        String dirty = "<img src=\"<img src=1\\ onerror=alert(1234)>\" onerror=\"alert('XSS')\">";
        String expected = "<img src=\"\"><!-- Not Allowed Attribute Filtered ( onerror=alert(1234)) --><img src=1\\>\" onerror=\"alert('XSS')\"&gt;";
        String result = filter.doFilter(dirty);
        assertEquals(expected, result);

        dirty = "<img src='<img src=1\\ onerror=alert(1234)>\" onerror=\"alert('XSS')\">";
        expected = "<img src=''><!-- Not Allowed Attribute Filtered ( onerror=alert(1234)) --><img src=1\\>\" onerror=\"alert('XSS')\"&gt;";
        result = filter.doFilter(dirty);
        assertEquals(expected, result);
    }

    /**
     * 2) SAX = XssSaxFilter
     * String result = XssSaxFilter.getInstance.doFilter(originalString)
     * Before using, you must make "lucy-xss-sax.xml" file at the classpath root directory.
     */
    @Test
    public void testSuperSetFix() {
        XssSaxFilter filter = XssSaxFilter.getInstance("lucy-xss-superset-sax.xml");
        String dirty = "<img src=\"<img src=1\\ onerror=alert(1234)>\" onerror=\"alert('XSS')\">";
        String expected = "<TABLE class=\"Naver_Layout_Main\" style=\"TABLE-LAYOUT: fixed\" cellSpacing=\"0\" cellPadding=\"0\" width=\"743\">" + "</TABLE>" + "<SPAN style=\"COLOR: #66cc99\"></SPAN>";
        String result = filter.doFilter(dirty);
        assertEquals(expected, result);
    }

}
