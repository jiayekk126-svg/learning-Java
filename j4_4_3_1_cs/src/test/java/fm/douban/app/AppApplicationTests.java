package fm.douban.app;

import fm.douban.app.control.SongListControl;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.Assert;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = SongListControl.class)
@ComponentScan(basePackages = "fm.douban.app.service.impl")
class AppApplicationTests {
    @Autowired
    private SongListControl songListControl;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/songlists")).andExpect(
            MockMvcResultMatchers.status().isOk()).andReturn();

        String contentAsString = mvcResult.getResponse().getContentAsString();

        Assert.notNull(contentAsString, "请求 /songlists 必须有内容");
        Assert.isTrue(contentAsString.contains("所有歌单"), "请求 /songlists 的页面中必须包含：所有歌单");
        Assert.isTrue(contentAsString.contains("经典之声｜经典港片的声音"), "请求 /songlists 的页面中必须包含：经典之声｜经典港片的声音");
        Assert.isTrue(contentAsString.contains("你永远不知道一个壮汉的耳机里放着什么"), "请求 /songlists 的页面中必须包含：你永远不知道一个壮汉的耳机里放着什么");
        Assert.isTrue(contentAsString.contains("锅炉不是锅"), "请求 /songlists 的页面中必须包含：锅炉不是锅");
        Assert.isTrue(contentAsString.contains("学习雷锋好榜样"), "请求 /songlists 的页面中必须包含：学习雷锋好榜样");
        Assert.isTrue(contentAsString.contains("豆瓣FM官方"), "请求 /songlists 的页面中必须包含：豆瓣FM官方");

    }

}
