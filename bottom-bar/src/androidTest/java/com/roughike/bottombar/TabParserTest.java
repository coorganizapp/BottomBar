package com.roughike.bottombar;

import android.content.Context;
import android.graphics.Color;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.LargeTest;
import android.support.test.runner.AndroidJUnit4;
import android.support.v4.content.ContextCompat;
import android.test.InstrumentationTestCase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class TabParserTest {
    private Context context;
    private List<BottomBarTab> tabs;

    @Before
    public void setUp() throws Exception {
        context = InstrumentationRegistry.getContext();
        tabs = new TabParser(context, new TabParser.Config.Builder().build(), com.roughike.bottombar.test.R.xml.dummy_tab_xml)
                .getTabs();
    }

    @Test
    public void correctAmountOfTabs() {
        assertEquals(5, tabs.size());
    }

    @Test
    public void idsNotEmpty() {
        assertNotSame(0, tabs.get(0).getId());
        assertNotSame(0, tabs.get(1).getId());
        assertNotSame(0, tabs.get(2).getId());
        assertNotSame(0, tabs.get(3).getId());
        assertNotSame(0, tabs.get(4).getId());
    }

    @Test
    public void correctTabTitles() {
        assertEquals("Recents", tabs.get(0).getTitle());
        assertEquals("Favorites", tabs.get(1).getTitle());
        assertEquals("Nearby", tabs.get(2).getTitle());
        assertEquals("Friends", tabs.get(3).getTitle());
        assertEquals("Food", tabs.get(4).getTitle());
    }

    @Test
    public void correctActiveColors() {
        assertEquals(Color.parseColor("#FF0000"), tabs.get(0).getActiveColor());

        assertEquals(
                ContextCompat.getColor(context, com.roughike.bottombar.test.R.color.test_random_color),
                tabs.get(1).getActiveColor()
        );

        assertEquals(Color.parseColor("#0000FF"), tabs.get(2).getActiveColor());
        assertEquals(Color.parseColor("#DAD666"), tabs.get(3).getActiveColor());
        assertEquals(Color.parseColor("#F00F00"), tabs.get(4).getActiveColor());
    }

    @Test
    public void iIconResourcesExist() {
        assertNotNull(ContextCompat.getDrawable(context, tabs.get(0).getIconResId()));
        assertNotNull(ContextCompat.getDrawable(context, tabs.get(1).getIconResId()));
        assertNotNull(ContextCompat.getDrawable(context, tabs.get(2).getIconResId()));
        assertNotNull(ContextCompat.getDrawable(context, tabs.get(3).getIconResId()));
        assertNotNull(ContextCompat.getDrawable(context, tabs.get(4).getIconResId()));
    }
}