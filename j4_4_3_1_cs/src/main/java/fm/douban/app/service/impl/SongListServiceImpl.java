package fm.douban.app.service.impl;

import com.alibaba.fastjson.JSON;
import fm.douban.app.model.SongList;
import fm.douban.app.service.SongListService;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

@Service
public class SongListServiceImpl implements SongListService {

  // 缓存所有歌单数据
  private static Map<String, SongList> songListMap = new HashMap<>();

  @Autowired
  private ResourceLoader loader;

  @PostConstruct
  public void init() {

    try {
      InputStream in = loader.getResource("classpath:data/songlists.json").getInputStream();
      String jsonString = IOUtils.toString(in, "utf-8");
      SongList[] lists = JSON.parseObject(jsonString, SongList[].class);
      for (SongList songList : lists) {
        songListMap.put(songList.getId(), songList);
      }
    } catch (IOException e) {
      e.fillInStackTrace();
    }

  }


  @Override
  public SongList get(String songListId) {
    return songListMap.get(songListId);
  }

  @Override
  public List<SongList> all() {
      return new ArrayList<>(songListMap.values());
  }
}
