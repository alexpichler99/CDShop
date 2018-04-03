package at.htl.cdshop.entity;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class BandTest {
    private Band band;
    private CD cd;

    @Before
    public void before() {
        band = new Band();
        cd = new CD();
    }

    @Test
    public void t001_addCd() {
        band.addCD(cd);

        assertThat(band.getCds().get(0), is(cd));
        assertThat(cd.getBand(), is(band));
    }

    @Test
    public void t002_removeCd() {
        band.removeCD(cd);

        assertThat(band.getCds().size(), is(0));
        assertNull(cd.getBand());
    }
}