package fm.douban.service.impl;

import fm.douban.model.Song;
import fm.douban.model.Subject;
import fm.douban.service.SongService;
import fm.douban.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SongService service;

    private static Map<String,Subject> map = new HashMap<>();

    static {
        Subject subject = new Subject();
        subject.setId("s001");
        subject.setName("成都");
        subject.setMusician("赵雷");
        map.put(subject.getId(),subject);

    }
    @Override
    public Subject get(String subjectid) {

        Subject subject = map.get(subjectid);

        List<Song> song = service.list(subjectid);
        subject.setSongs(song);
        return subject;
    }
}
