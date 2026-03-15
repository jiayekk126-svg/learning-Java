package fm.douban;


import fm.douban.model.Song;
import fm.douban.model.Subject;
import fm.douban.service.SubjectService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Application
 */
public class Application {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("fm.douban");
        SubjectService subjectService = context.getBean(
                SubjectService.class
        );
        Subject subject = subjectService.get("s001");
        System.out.println("专辑：" + subject.getName() + " 音乐家：" +subject.getMusician() + " 包含：" + subject.getSongs().size() + "首歌");

        StringBuilder songInfo = new StringBuilder();
        for (Song song : subject.getSongs()) {
            songInfo.append("歌曲名：").append(song.getName())
                    .append("\n歌词片段：").append(song.getLyrics())
                    .append("\n歌曲ID：").append(song.getId())
                    .append("\n-------------------\n");
        }

        System.out.println("专辑：" + subject.getName() +
                "\n音乐家：" + subject.getMusician() +
                "\n包含歌曲：" + subject.getSongs().size() + "首\n" +
                songInfo.toString());

    }
}