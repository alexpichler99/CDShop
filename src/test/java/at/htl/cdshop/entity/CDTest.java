package at.htl.cdshop.entity;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class CDTest {
    private CD cd;
    private Track track;

    @Before
    public void before() {
        cd = new CD();
        track = new Track();
    }

    @Test
    public void t001_addCd() {
        cd.addTrack(track);

        assertThat(cd.getTracks().get(0), is(track));
        assertThat(track.getCd(), is(cd));
    }

    @Test
    public void t002_removeCd() {
        cd.removeTrack(track);

        assertThat(cd.getTracks().size(), is(0));
        assertNull(track.getCd());
    }
}