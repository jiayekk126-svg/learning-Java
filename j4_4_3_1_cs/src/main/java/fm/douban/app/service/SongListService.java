package fm.douban.app.service;

import fm.douban.app.model.SongList;
import java.util.List;

/**
 * SubjectListService
 */
public interface SongListService {

  SongList get(String songListId);

  List<SongList> all();
}