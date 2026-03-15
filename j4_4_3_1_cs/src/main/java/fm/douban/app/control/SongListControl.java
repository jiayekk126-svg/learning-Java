package fm.douban.app.control;

import java.util.*;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import fm.douban.app.model.*;
import fm.douban.app.service.*;
import org.springframework.ui.Model;

@Controller
public class SongListControl {

    @Autowired
    private SongListService songListService;

    @RequestMapping("/songlist")
    public String index( @RequestParam("id") String id ,Model model) {

        SongList songList = songListService.get(id);    

        model.addAttribute("songList", songList);
        model.addAttribute("title", "歌单信息");  

        return "songList";
    }

    @RequestMapping("/songlists")
    public String songlists(Model model) {

        List<SongList> sls = songListService.all();

        model.addAttribute("sls", sls);
        model.addAttribute("title", "所有歌单");

        return "sls";
    }
}