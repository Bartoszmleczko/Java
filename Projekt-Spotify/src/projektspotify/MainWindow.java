/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektspotify;

import DBClasses.*;

import com.sun.javafx.scene.control.skin.CustomColorDialog;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import javafx.application.Application;
import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import java.util.List;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Screen;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Bartosz
 */
public class MainWindow extends Application {

    private Scene scene;
    Stage stage = new Stage();
    private VBox root = new VBox();
    private HBox playBtnBox = new HBox(30);
    private HBox sliderBox = new HBox(10);
    private Button prevTr = new Button("Poprzedni");
    private Button playBtn = new Button("Graj");
    private Button stopBtn = new Button("Stop");
    private Button nextButton = new Button("Następny");
    private Slider slider = new Slider();
    private Label time = new Label();
    private Label endTime = new Label();

    private TabPane pane = new TabPane();
    private Tab musician = new Tab("Artyści");
    private Tab track = new Tab("Utwory");
    private Tab album = new Tab("Albumy");
    private Tab playlist = new Tab("Playlisty");

    private VBox mMainBox = new VBox(10);
    private VBox mMenuBox = new VBox(30);
    private VBox mSearchBox = new VBox(30);
    private HBox mListBox = new HBox();
    private VBox mButtonBox = new VBox(30);
    private HBox mConcatBox = new HBox(100);
    private VBox mInfoBox = new VBox(10);
    private HBox mConBox2 = new HBox();

    private Label mArtLab = new Label("Artysta: ");
    private Label mAlbLab = new Label("Album");
    private ObservableList<String> mInftracks = FXCollections.observableArrayList();
    private ListView<String> minfoListView = new ListView<String>();

    ObservableList<Integer> mInvObsArr = FXCollections.observableArrayList();
    ListView<Integer> minvListView = new ListView<>();
    ObservableList<Integer> mInvInfObsArr = FXCollections.observableArrayList();
    ListView<Integer> minvInfListView = new ListView<>();
    ListView<String> mListView = new ListView<>();
    ObservableList<String> mList = FXCollections.observableArrayList(); //listbox

    private Button mPlayButton = new Button("Wyswietl powiazane utwory");                      //buttonbox
    private Button mAddToPlaylistButton = new Button("Dodaj do playlisty");
    private Button mCreatePlaylistButton = new Button("Utwórz Playliste");
    private Button mAddToFavourites = new Button("Wyświetl informacje o artyście");
    private Button mDelArt = new Button("Usuń Artyste");
    private Button mCreateArt = new Button("Dodaj artyste");
    private Button mAddInfBtn = new Button("Dodaj utwory");
    private Button mPlayBtn = new Button("Odtwarzaj");

    private VBox tSearchBox = new VBox(30);
    private HBox tListBox = new HBox();
    private VBox tButtonBox = new VBox(30);
    private HBox tConcatBox = new HBox(100);
    private VBox tInfoBox = new VBox(10);

    private Label tArtLab = new Label("Artysta: ");
    private Label tAlbLab = new Label("Album");

    ObservableList<Integer> tInvObsArr = FXCollections.observableArrayList();
    ListView<Integer> tinvListView = new ListView<>();
    ListView<String> tListView = new ListView<>();
    ObservableList<String> tList = FXCollections.observableArrayList(); //listbox

    private ObservableList<String> mtInftracks = FXCollections.observableArrayList();
    private ListView<String> tinfoListView = new ListView<String>();

    private Button tPlayButton = new Button("Odtwórz");                      //buttonbox
    private Button tAddToPlaylistButton = new Button("Dodaj do playlisty");
    private Button tCreatePlaylistButton = new Button("Utwórz Playliste");
    private Button tAddToFavourites = new Button("Wyświetl Album");
    private TextArea tTextDesc = new TextArea();
    private Button tInfoButt = new Button("O utworze");
    private Button tAddTrackBBtn = new Button("Dodaj utwór");
    private Button tDeleteTrackBtn = new Button("Usuń utwór");

    private VBox aSearchBox = new VBox(30);
    private HBox aListBox = new HBox();
    private VBox aButtonBox = new VBox(30);
    private HBox aConcatBox = new HBox(100);
    private VBox aInfoBox = new VBox(10);
    private HBox aConBox2 = new HBox();
    private VBox aMenuBox = new VBox(30);

    private Label aArtLab = new Label("Artysta: ");
    private Label aAlbLab = new Label("Album: ");
    private ObservableList<String> aInftracks = FXCollections.observableArrayList();
    private ListView<String> ainfoListView = new ListView<String>();

    ObservableList<Integer> aInvObsArr = FXCollections.observableArrayList();
    ListView<Integer> ainvListView = new ListView<>();
    ListView<String> aListView = new ListView<>();
    ObservableList<String> aList = FXCollections.observableArrayList(); //listbox

    private Button aPlayButton = new Button("Odtwórz");                      //buttonbox
    private Button aAddToPlaylistButton = new Button("Dodaj do playlisty");
    private Button aCreatePlaylistButton = new Button("Utwórz Playliste");
    private Button aAddToFavourites = new Button("Wyświetl utwory");
    private Button aAddAlbumBBtn = new Button("Dodaj album");
    private Button aDeleteAlbumBtn = new Button("Usuń album");
    private Button aAddInfBtn = new Button("Dodaj");

    private VBox pSearchBox = new VBox(30);
    private HBox pListBox = new HBox();
    private VBox pButtonBox = new VBox(30);
    private HBox pConcatBox = new HBox(100);
    private HBox pTrackBox = new HBox();
    private VBox ptrBtnBox = new VBox();

    ListView<String> pListView = new ListView<>();
    ObservableList<String> pList = FXCollections.observableArrayList(); //listbox

    private Button pPlayButton = new Button("Wyswietl utwory z playlisty");                      //buttonbox
    private Button pAddToPlaylistButton = new Button("Usun playliste");
    private Button pCreatePlaylistButton = new Button("Utwórz Playliste");
    private Button pAddToFavourites = new Button("Dodaj do ulubionych");

    final ListView<String> listView1 = new ListView<>();
    final ObservableList<Integer> invList = FXCollections.observableArrayList();
    final ListView<Integer> invListView = new ListView<>();
    private Button removeTrack = new Button("Usun z playlisty");
    final ObservableList<String> olist = FXCollections.observableArrayList();

    Configuration configuration = new Configuration().configure("hibernate.cfg.xml");

    @Override
    public void start(Stage stage) throws Exception {
        stopBtn.setVisible(false);
        stopBtn.setPrefWidth(5);
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        pane.setPrefSize(bounds.getWidth(), bounds.getHeight());
        configuration.addAnnotatedClass(Artists.class);
        configuration.addAnnotatedClass(Albums.class);
        configuration.addAnnotatedClass(Tracks.class);
        configuration.addAnnotatedClass(Playlists.class);
        tListView.prefHeightProperty().bind(stage.heightProperty());
        pListView.prefHeightProperty().bind(stage.heightProperty());
        minvListView.setVisible(false);
        SessionFactory factory = configuration.buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        mAddToFavourites.setMaxWidth(Double.MAX_VALUE);
        setDisplay();

        setPlayList(session);
        setArtList(session);
        setTrList(session);
        setAlbList(session);
        transaction.commit();
        session.close();
        factory.close();
        aListView.getSelectionModel().select(0);
        aListView.getFocusModel().focus(0);
        tListView.getSelectionModel().select(0);
        tListView.getFocusModel().focus(0);
        mListView.getSelectionModel().select(0);
        mListView.getFocusModel().focus(0);
        pListView.getSelectionModel().select(0);
        pListView.getFocusModel().focus(0);
        minvListView.getSelectionModel().select(0);
        minvListView.getFocusModel().focus(0);
        tinvListView.getSelectionModel().select(0);
        tinvListView.getFocusModel().focus(0);
        ainvListView.getSelectionModel().select(0);
        ainvListView.getFocusModel().focus(0);

        mCreatePlaylistButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {

                createPlaylist();
            }
        });
        mAddToFavourites.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                SessionFactory fact = configuration.buildSessionFactory();
                Session ses = fact.openSession();
                Transaction tr = ses.beginTransaction();
                Criteria c = ses.createCriteria(Artists.class);
                Stage showDescription = new Stage();

                HBox descBox = new HBox(10);
                c.add(Restrictions.like("art_id", minvListView.getSelectionModel().getSelectedItem()));
                Artists art1 = (Artists) c.uniqueResult();
                System.out.println(art1.getDescription());
                tTextDesc.setText(art1.getDescription());
                tTextDesc.setWrapText(true);
                descBox.getChildren().add(tTextDesc);
                Scene descScene = new Scene(descBox, 200, 150);
                descBox.setId("box");
                descScene.getStylesheets().add(getClass().getResource("newCascadeStyleSheet.css").toExternalForm());
                showDescription.setScene(descScene);
                showDescription.show();
                tr.commit();
                ses.close();
                fact.close();
            }
        });
        mListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> ov, String t, String t1) {
                minvListView.getSelectionModel().select(mListView.getSelectionModel().getSelectedIndex());
                minvListView.getFocusModel().focus(mListView.getSelectionModel().getSelectedIndex());
            }
        });
        mDelArt.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {

                SessionFactory fact = configuration.buildSessionFactory();
                Session ses = fact.openSession();
                Transaction tr = ses.beginTransaction();

                Criteria c = ses.createCriteria(Artists.class);
                c.add(Restrictions.like("art_id", minvListView.getSelectionModel().getSelectedItem()));
                Artists art = (Artists) c.uniqueResult();

                List<Tracks> tra = art.getTracks();
                List<Albums> alb = art.getAlbums();
                int i = tra.size() - 1;
                if (tra.size() > 0) {
                    while (i >= 0) {
                        ses.delete(tra.get(i));
                        if (!tra.get(i).getPlaylists().isEmpty()) {
                            Criteria c1 = ses.createCriteria(Playlists.class);
                            List<Playlists> pl = c1.list();
                            for (Playlists p : pl) {
                                if (p.getTracks().contains(tra.get(i))) {
                                    p.getTracks().remove(tra.get(i));
                                }
                            }
                        }
                        i--;
                    }
                }
                Criteria c2 = ses.createCriteria(Albums.class);
                List<Albums> albs = c2.list();
                int j = 0;
                List<String>  al = new ArrayList<>();
                for (Albums a : albs) {
                    if (a.getArtist().getArt_id() == art.getArt_id()) {
                        al.add(a.getAlb_title());
                        ses.delete(a);

                    }
                    j++;
                }
                for(int h=0;h<al.size();h++){
                    aList.remove(al.get(h));
                }
                setTrList(ses);
                mInvObsArr.remove(mListView.getSelectionModel().getSelectedIndex());
                mList.remove(mListView.getSelectionModel().getSelectedIndex());
                ses.delete(art);
                tr.commit();
                ses.close();
                fact.close();
            }
        });
        mPlayButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {

                SessionFactory fact = configuration.buildSessionFactory();
                Session ses = fact.openSession();
                Transaction tr = ses.beginTransaction();
                Criteria c = ses.createCriteria(Artists.class);
                c.add(Restrictions.like("art_id", minvListView.getSelectionModel().getSelectedItem()));
                Artists art = (Artists) c.uniqueResult();
                List<Tracks> tracks = art.getTracks();
                ObservableList<String> asd = FXCollections.observableArrayList();
                for (Tracks k : tracks) {
                    if (art.getArt_id() == k.getArt().getArt_id()) {
                        asd.add(k.getTrack_title());
                    }
                }
                mArtLab.setText("Artysta: " + art.getArt_name());
                minfoListView.setItems(asd);
                tr.commit();
                ses.close();
                fact.close();
            }
        });
        mAddToPlaylistButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {

                Stage addtoPlaylistStage = new Stage();
                final Button selectPlaylistButton = new Button("Wybierz Playliste");
                SessionFactory fact = configuration.buildSessionFactory();
                Session ses = fact.openSession();
                Transaction tr = ses.beginTransaction();
                ObservableList<String> asd = FXCollections.observableArrayList();
                Criteria c = ses.createCriteria(Artists.class);
                c.add(Restrictions.like("art_id", minvListView.getSelectionModel().getSelectedItem()));
                Artists art = (Artists) c.uniqueResult();
                List<Tracks> tracks = art.getTracks();
                Criteria c2 = ses.createCriteria(Playlists.class);
                List<Tracks> tracks2 = new LinkedList<Tracks>();

                int i = 0;
                for (Tracks k : tracks) {
                    if (art.getArt_id() == k.getArt().getArt_id()) {
                        asd.add(k.getTrack_title());
                        tracks2.add(i, k);
                        i++;
                    }
                }

                ObservableList<String> pList2 = FXCollections.observableArrayList();
                pList2.addAll(getAllPlaylists(ses));
                final ListView<String> asdListView = new ListView<>(pList2);
                addToPlaylistM(tracks2, asdListView, selectPlaylistButton);
                HBox box = new HBox(10);
                box.getChildren().addAll(stopBtn,asdListView, selectPlaylistButton);
                Scene scene1 = new Scene(box, 470, 200);
                box.setId("box");
                scene1.getStylesheets().add(getClass().getResource("newCascadeStyleSheet.css").toExternalForm());
                addtoPlaylistStage.setScene(scene1);
                addtoPlaylistStage.show();
                tr.commit();
                ses.close();
                fact.close();

            }
        });
        mCreateArt.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                SessionFactory fact = configuration.buildSessionFactory();
                Session ses = fact.openSession();
                Transaction tr = ses.beginTransaction();
                Stage st = new Stage();
                final TextField insArtName = new TextField("");
                final TextField insAlbName = new TextField("");
                final TextField insTrackName1 = new TextField("");
                final TextField insDesc = new TextField("");
                final TextField insRelYear = new TextField("");
                final Label arti = new Label("Artysta");
                final Label desc = new Label("Opis Artysty");
                final Label album = new Label("Album");
                final Label rel = new Label("Rok wydania");
                final Label trackn = new Label("Nazwa Utworu");

                Button add = new Button("Dodaj artyste");
                HBox box1 = new HBox(5);
                box1.getChildren().addAll(arti, insArtName);
                HBox box2 = new HBox(5);
                box2.getChildren().addAll(desc, insDesc);
                HBox box3 = new HBox(5);
                box3.getChildren().addAll(album, insAlbName);
                HBox box4 = new HBox(5);
                box4.getChildren().addAll(rel, insRelYear);
                HBox box5 = new HBox(5);
                box5.getChildren().addAll(trackn, insTrackName1);
                VBox artAlbBox = new VBox(10);
                artAlbBox.getChildren().addAll(box1, box2, box3, box4, box5, add);
                add.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent t) {
                        SessionFactory fact = configuration.buildSessionFactory();
                        Session ses = fact.openSession();
                        Transaction tr = ses.beginTransaction();
                        if (!insArtName.getText().equals("") && !insAlbName.getText().equals("") && !insTrackName1.getText().equals("") && !insDesc.getText().equals("") && !insRelYear.getText().equals("")) {

                            int relYear = Integer.parseInt(insRelYear.getText());

                            Artists art = new Artists(insArtName.getText(), insDesc.getText());
                            Albums alb = new Albums(insAlbName.getText(), relYear);
                            Tracks trac = new Tracks(insTrackName1.getText());
                            trac.setArt(art);
                            trac.setAlb(alb);
                            List<Tracks> tracs = new ArrayList<Tracks>();
                            tracs.add(trac);
                            alb.setArtist(art);
                            alb.setTracks(tracs);
                            art.setTracks(tracs);
                            ses.save(art);
                            ses.save(alb);
                            ses.save(trac);
                            mInvObsArr.add(art.getArt_id());
                            mList.add(art.getArt_name());
                            tInvObsArr.add(trac.getTrack_id());
                            tList.add(trac.getTrack_title());
                            aInvObsArr.add(alb.getAlb_id());
                            aList.add(alb.getAlb_title());
                            tr.commit();
                            ses.close();
                            fact.close();
                            insArtName.clear();
                            insDesc.clear();
                            insAlbName.clear();
                            insRelYear.clear();
                            insTrackName1.clear();

                        } else {
                            System.out.println("Uzupelnij wszystkie pola");
                            tr.commit();
                            ses.close();
                            fact.close();
                        }

                    }
                });
                Scene sc = new Scene(artAlbBox, 400, 350);
                box1.setAlignment(Pos.CENTER);
                box2.setAlignment(Pos.CENTER);
                box3.setAlignment(Pos.CENTER);
                box4.setAlignment(Pos.CENTER);
                box5.setAlignment(Pos.CENTER);                
                artAlbBox.setAlignment(Pos.CENTER);
                artAlbBox.setId("box");
                sc.getStylesheets().add(getClass().getResource("newCascadeStyleSheet.css").toExternalForm());
                st.setScene(sc);
                st.show();
                tr.commit();
                ses.close();
                fact.close();
            }
        });
        mPlayBtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                String musicFile = "Master Bounce_0002.wav"; 

                Media sound = new Media(new File(musicFile).toURI().toString());
                final MediaPlayer mediaPlayer = new MediaPlayer(sound);
                mediaPlayer.play();
                nextButton.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent t) {
                        mediaPlayer.stop();
                        String musicFile = "Master Bounce_0002.wav";
                        Media sound = new Media(new File(musicFile).toURI().toString());
                        final MediaPlayer mediaPlayer = new MediaPlayer(sound);
                        mediaPlayer.play();
                    }
                });
                prevTr.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent t) {
                        mediaPlayer.stop();
                        String musicFile = "anniversary.wav";
                        Media sound = new Media(new File(musicFile).toURI().toString());
                        final MediaPlayer mediaPlayer = new MediaPlayer(sound);
                        mediaPlayer.play();
                    }
                });
                playBtn.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent t) {
                        mediaPlayer.play();
                        playBtnBox.getChildren().addAll(prevTr, stopBtn, nextButton);
                    }
                });
                stopBtn.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent t) {
                        mediaPlayer.stop();
                        playBtnBox.getChildren().addAll(prevTr, playBtn, nextButton);
                    }
                });
            }

        });
        mAddInfBtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {

                if (!minfoListView.getItems().isEmpty()) {
                    Stage addtoPlaylistStage = new Stage();
                    final Button selectPlaylistButton = new Button("Wybierz Playliste");
                    ObservableList<String> asd = FXCollections.observableArrayList();
                    final ListView<String> asdListView = new ListView<>();
                    SessionFactory fact = configuration.buildSessionFactory();
                    Session ses = fact.openSession();
                    Transaction tr = ses.beginTransaction();
                    Criteria c = ses.createCriteria(Tracks.class);
                    c.add(Restrictions.like("track_title", minfoListView.getSelectionModel().getSelectedItem()));
                    Tracks track1 = (Tracks) c.uniqueResult();
                    System.out.println(track1.getTrack_title());
                    Criteria c1 = ses.createCriteria(Playlists.class);
                    List<Playlists> play = c1.list();
                    String[] arr = new String[play.size()];
                    int i = 0;
                    for (Playlists p : play) {
                        arr[i] = p.getPlay_name();
                        i++;
                    }
                    asd.addAll(arr);
                    asdListView.setItems(asd);
                    selectPlaylistButton.setOnAction(new EventHandler<ActionEvent>() {

                        @Override
                        public void handle(ActionEvent t) {
                            SessionFactory fact = configuration.buildSessionFactory();
                            Session ses = fact.openSession();
                            Transaction tr = ses.beginTransaction();
                            Criteria c = ses.createCriteria(Playlists.class);
                            c.add(Restrictions.like("play_name", asdListView.getSelectionModel().getSelectedItem()));
                            Playlists play = (Playlists) c.uniqueResult();
                            List<Tracks> trq = play.getTracks();
                            trq.add(track1);
                            play.setTracks(trq);
                            ses.update(play);
                            tr.commit();
                            ses.close();
                            fact.close();
                        }
                    });
                    HBox box = new HBox(10);
                    box.getChildren().addAll(asdListView, selectPlaylistButton);
                    box.setId("box");
                    Scene sc = new Scene(box, 500, 300);
                    sc.getStylesheets().add(getClass().getResource("newCascadeStyleSheet.css").toExternalForm());
                    addtoPlaylistStage.setScene(sc);
                    addtoPlaylistStage.show();
                    tr.commit();
                    ses.close();
                    fact.close();
                }

            }
        });

        tListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> ov, String t, String t1) {
                tinvListView.getSelectionModel().select(tListView.getSelectionModel().getSelectedIndex());
                tinvListView.getFocusModel().focus(tListView.getSelectionModel().getSelectedIndex());
            }
        });
        tInfoButt.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                SessionFactory fact = configuration.buildSessionFactory();
                Session ses = fact.openSession();
                Transaction tr = ses.beginTransaction();
                Criteria c = ses.createCriteria(Tracks.class);
                c.add(Restrictions.like("track_id", tinvListView.getSelectionModel().getSelectedItem()));
                Tracks track = (Tracks) c.uniqueResult();
                tArtLab.setText("Artysta: " + track.getArt().getArt_name());
                tAlbLab.setText("Album: " + track.getAlb().getAlb_title());
                tr.commit();
                ses.close();
                fact.close();

            }
        });
        tPlayButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                String musicFile = "anniversary.wav";     // For example

                Media sound = new Media(new File(musicFile).toURI().toString());
                MediaPlayer mediaPlayer = new MediaPlayer(sound);
                mediaPlayer.play();
            }
        });
        tCreatePlaylistButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                createPlaylist();
            }
        });
        tAddToPlaylistButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                Stage addtoPlaylistStage = new Stage();
                final Button selectPlaylistButton = new Button("Wybierz Playliste");
                ObservableList<String> asd = FXCollections.observableArrayList();
                final ListView<String> asdListView = new ListView<>();
                SessionFactory fact = configuration.buildSessionFactory();
                Session ses = fact.openSession();
                Transaction tr = ses.beginTransaction();
                Criteria c = ses.createCriteria(Tracks.class);
                c.add(Restrictions.like("track_id", tinvListView.getSelectionModel().getSelectedItem()));
                Tracks track1 = (Tracks) c.uniqueResult();
                System.out.println(track1.getTrack_title());
                Criteria c1 = ses.createCriteria(Playlists.class);
                List<Playlists> play = c1.list();
                String[] arr = new String[play.size()];
                int i = 0;
                for (Playlists p : play) {
                    arr[i] = p.getPlay_name();
                    i++;
                }
                asd.addAll(arr);
                asdListView.setItems(asd);
                selectPlaylistButton.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent t) {
                        SessionFactory fact = configuration.buildSessionFactory();
                        Session ses = fact.openSession();
                        Transaction tr = ses.beginTransaction();
                        Criteria c = ses.createCriteria(Playlists.class);
                        c.add(Restrictions.like("play_name", asdListView.getSelectionModel().getSelectedItem()));
                        Playlists play = (Playlists) c.uniqueResult();
                        List<Tracks> trq = play.getTracks();
                        trq.add(track1);
                        play.setTracks(trq);
                        ses.update(play);
                        tr.commit();
                        ses.close();
                        fact.close();
                    }
                });
                HBox box = new HBox(10);
                box.getChildren().addAll(asdListView, selectPlaylistButton);
                
                box.setId("box");
                Scene sc = new Scene(box, 500, 300);
                sc.getStylesheets().add(getClass().getResource("newCascadeStyleSheet.css").toExternalForm());
                addtoPlaylistStage.setScene(sc);
                addtoPlaylistStage.show();
                tr.commit();
                ses.close();
                fact.close();
            }
        });
        tAddTrackBBtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                SessionFactory fact = configuration.buildSessionFactory();
                Session ses = fact.openSession();
                Transaction tr = ses.beginTransaction();
                Stage st = new Stage();
                final ComboBox<String> artComBox = new ComboBox<>();
                final ComboBox<String> albComBox = new ComboBox<>();
                final ObservableList<String> AlbobsArr = FXCollections.observableArrayList();
                final ObservableList<String> ArtobsArr = FXCollections.observableArrayList();
                Criteria c = ses.createCriteria(Artists.class);
                List<Artists> lart = c.list();
                for (Artists a : lart) {
                    ArtobsArr.add(a.getArt_name());
                }

                artComBox.setItems(ArtobsArr);
                final TextField insArtName = new TextField("");
                final TextField insAlbName = new TextField("");
                final TextField insTrackName1 = new TextField("");

                final Label arti = new Label("Artysta");
                final Label album = new Label("Album");
                final Label trackn = new Label("Nazwa Utworu");
                insArtName.setEditable(false);
                insAlbName.setEditable(false);
                artComBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {

                    @Override
                    public void changed(ObservableValue ov, Object t, Object t1) {
                        SessionFactory fact = configuration.buildSessionFactory();
                        Session ses = fact.openSession();
                        Transaction tr = ses.beginTransaction();
                        AlbobsArr.clear();
                        insArtName.setText(artComBox.getSelectionModel().getSelectedItem());
                        Criteria c1 = ses.createCriteria(Albums.class);
                        List<Albums> albs = c1.list();
                        for (Albums a : albs) {
                            if (a.getArtist().getArt_name().equals(artComBox.getSelectionModel().getSelectedItem())) {
                                AlbobsArr.add(a.getAlb_title());
                            }
                        }
                        albComBox.setItems(AlbobsArr);
                        albComBox.getSelectionModel().select(0);
                        insAlbName.setText(albComBox.getSelectionModel().getSelectedItem());
                        tr.commit();
                        ses.close();
                        fact.close();
                    }
                });
                albComBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

                    @Override
                    public void changed(ObservableValue<? extends String> ov, String t, String t1) {
                        insAlbName.setText(albComBox.getSelectionModel().getSelectedItem());
                    }
                });
                Button add = new Button("Dodaj artyste");
                HBox box1 = new HBox(5);
                box1.getChildren().addAll(arti, insArtName, artComBox);
                HBox box3 = new HBox(5);
                box3.getChildren().addAll(album, insAlbName, albComBox);

                add.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent t) {
                        SessionFactory fact = configuration.buildSessionFactory();
                        Session ses = fact.openSession();
                        Transaction tr = ses.beginTransaction();
                        if (!insArtName.equals("") && !insAlbName.equals("") && !insTrackName1.equals("")) {
                            Tracks track = new Tracks(insTrackName1.getText());
                            Criteria c3 = ses.createCriteria(Albums.class);
                            c3.add(Restrictions.like("alb_title", insAlbName.getText()));
                            Albums a = (Albums) c3.uniqueResult();
                            Artists ar = a.getArtist();
                            track.setAlb(a);
                            track.setArt(ar);
                            ses.save(track);
                            tInvObsArr.add(track.getTrack_id());
                            tList.add(track.getTrack_title());
                            tr.commit();
                            ses.close();
                            fact.close();
                            insArtName.setText("");
                            insAlbName.setText("");
                            AlbobsArr.clear();
                            ArtobsArr.clear();
                            insTrackName1.setText("");
                            st.close();
                        }
                    }
                });
                HBox box5 = new HBox(5);
                box5.getChildren().addAll(trackn, insTrackName1);
                VBox artAlbBox = new VBox(10);
                artAlbBox.getChildren().addAll(box1, box3, box5, add);
                                box1.setAlignment(Pos.CENTER);

                box3.setAlignment(Pos.CENTER);

                box5.setAlignment(Pos.CENTER); 
                artAlbBox.setAlignment(Pos.CENTER);
                Scene sc = new Scene(artAlbBox, 460, 230);
                artAlbBox.setId("box");
                sc.getStylesheets().add(getClass().getResource("newCascadeStyleSheet.css").toExternalForm());
                st.setScene(sc);
                st.show();
                tr.commit();
                ses.close();
                fact.close();
            }
        });
        tDeleteTrackBtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                SessionFactory fact = configuration.buildSessionFactory();
                Session ses = fact.openSession();
                Transaction trans = ses.beginTransaction();
                Criteria c = ses.createCriteria(Tracks.class);
                c.add(Restrictions.like("track_id", tinvListView.getSelectionModel().getSelectedItem()));
                Tracks tra = (Tracks) c.uniqueResult();
                tInvObsArr.remove(tinvListView.getSelectionModel().getSelectedIndex());
                tList.remove(tListView.getSelectionModel().getSelectedIndex());
                ses.delete(tra);
                trans.commit();
                ses.close();
                fact.close();
            }
        });
        tAddToFavourites.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                SessionFactory fact = configuration.buildSessionFactory();
                Session ses = fact.openSession();
                Transaction tr = ses.beginTransaction();
                Criteria c = ses.createCriteria(Tracks.class);
                c.add(Restrictions.like("track_id", tinvListView.getSelectionModel().getSelectedItem()));
                Tracks track1 = (Tracks) c.uniqueResult();
                tArtLab.setText("Artysta: " + track1.getArtist().getArt_name());
                tAlbLab.setText("Album: " + track1.getAlb().getAlb_title());
                tr.commit();
                ses.close();
                fact.close();
            }
        });

        aPlayButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                String musicFile = "anniversary.wav";     // For example

                Media sound = new Media(new File(musicFile).toURI().toString());
                MediaPlayer mediaPlayer = new MediaPlayer(sound);
                mediaPlayer.play();
            }
        });
        aCreatePlaylistButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                createPlaylist();
            }
        });
        aAddToFavourites.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                SessionFactory fact = configuration.buildSessionFactory();
                Session ses = fact.openSession();
                Transaction tr = ses.beginTransaction();
                Criteria c = ses.createCriteria(Albums.class);
                c.add(Restrictions.like("alb_id", ainvListView.getSelectionModel().getSelectedItem()));
                Albums alb = (Albums) c.uniqueResult();
                System.out.println(alb.getAlb_id());
                ObservableList<String> asd = FXCollections.observableArrayList();
                Criteria c1 = ses.createCriteria(Tracks.class);
                List<Tracks> tra = c1.list();
                for (Tracks trc : tra) {
                    if (trc.getAlb().getAlb_id() == alb.getAlb_id()) {
                        asd.add(trc.getTrack_title());
                        aArtLab.setText("Artysta: " + trc.getArt().getArt_name());
                        aAlbLab.setText("Album: " + trc.getAlb().getAlb_title());
                    }
                }
                ainfoListView.setItems(asd);
                tr.commit();
                ses.close();
                fact.close();
            }
        });
        aAddToPlaylistButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {

                Stage addtoPlaylistStage = new Stage();
                final Button selectPlaylistButton = new Button("Wybierz Playliste");
                SessionFactory fact = configuration.buildSessionFactory();
                Session ses = fact.openSession();
                Transaction tr = ses.beginTransaction();
                ObservableList<String> asd = FXCollections.observableArrayList();
                Criteria c = ses.createCriteria(Albums.class);
                c.add(Restrictions.like("alb_id", ainvListView.getSelectionModel().getSelectedItem()));
                Albums art = (Albums) c.uniqueResult();
                Criteria c1 = ses.createCriteria(Tracks.class);
                List<Tracks> tracks = c1.list();
                List<Tracks> tracks2 = new ArrayList<Tracks>();

                int i = 0;
                for (Tracks k : tracks) {
                    if (k.getAlb().getAlb_id() == art.getAlb_id()) {
                        asd.add(k.getTrack_title());
                        tracks2.add(i, k);
                        i++;
                    }
                }
                ObservableList<String> pList2 = FXCollections.observableArrayList();
                pList2.addAll(getAllPlaylists(ses));
                final ListView<String> asdListView = new ListView<>(pList2);
                selectPlaylistButton.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent t) {
                        try {
                            SessionFactory fact = configuration.buildSessionFactory();
                            Session ses = fact.openSession();
                            Transaction tr = ses.beginTransaction();
                            Criteria c3 = ses.createCriteria(Playlists.class);
                            c3.add(Restrictions.like("play_name", asdListView.getSelectionModel().getSelectedItem()));
                            Playlists play = (Playlists) c3.uniqueResult();
                            List<Tracks> pt = play.getTracks();
                            pt.addAll(tracks2);
                            play.setTracks(pt);
                            ses.update(play);
                            tr.commit();
                            ses.close();
                            fact.close();
                        } catch (NullPointerException n) {
                            for (StackTraceElement ste : n.getStackTrace()) {
                                System.out.println(n.getStackTrace().toString());
                            }
                        }
                    }
                });
                HBox box = new HBox(10);
                box.getChildren().addAll(stopBtn,asdListView, selectPlaylistButton);
                Scene scene1 = new Scene(box, 500, 200);
                box.setId("box");
                scene1.getStylesheets().add(getClass().getResource("newCascadeStyleSheet.css").toExternalForm());
                addtoPlaylistStage.setScene(scene1);
                addtoPlaylistStage.show();

                tr.commit();
                ses.close();
                fact.close();
            }

        });
        aListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> ov, String t, String t1) {
                ainvListView.getSelectionModel().select(aListView.getSelectionModel().getSelectedIndex());
                ainvListView.getFocusModel().focus(aListView.getSelectionModel().getSelectedIndex());
            }
        });
        aAddAlbumBBtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                SessionFactory fact = configuration.buildSessionFactory();
                Session ses = fact.openSession();
                Transaction tr = ses.beginTransaction();
                Stage st = new Stage();
                final ComboBox<String> artComBox = new ComboBox<>();
                final ObservableList<String> artObsArr = FXCollections.observableArrayList();
                Criteria c = ses.createCriteria(Artists.class);
                List<Artists> arts = c.list();
                for (Artists a : arts) {
                    artObsArr.add(a.getArt_name());
                }
                artComBox.setItems(artObsArr);
                final TextField insArtName = new TextField("");
                final TextField insAlbName = new TextField("");
                final TextField insTrackName1 = new TextField("");
                final TextField insRelYear = new TextField("");
                final Label arti = new Label("Artysta");
                final Label album = new Label("Album");
                final Label rel = new Label("Rok wydania");
                final Label trackn = new Label("Nazwa Utworu");
                Button add = new Button("Dodaj album");
                HBox box1 = new HBox(5);
                box1.getChildren().addAll(arti, insArtName, artComBox);
                HBox box3 = new HBox(5);
                box3.getChildren().addAll(album, insAlbName);
                HBox box4 = new HBox(5);
                box4.getChildren().addAll(rel, insRelYear);
                HBox box5 = new HBox(5);
                box5.getChildren().addAll(trackn, insTrackName1);
                VBox artAlbBox = new VBox(10);
                artAlbBox.getChildren().addAll(box1, box3, box4, box5, add);
                artComBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

                    @Override
                    public void changed(ObservableValue<? extends String> ov, String t, String t1) {
                        insArtName.setText(artComBox.getSelectionModel().getSelectedItem());
                    }
                });
                add.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent t) {
                        if (!insArtName.equals("") && !insAlbName.equals("") && !insRelYear.equals("") && !insTrackName1.equals("")) {
                            SessionFactory fact = configuration.buildSessionFactory();
                            Session ses = fact.openSession();
                            Transaction tr = ses.beginTransaction();
                            int rel = Integer.parseInt(insRelYear.getText());
                            Albums alb = new Albums(insAlbName.getText(), rel);
                            Tracks track = new Tracks(insTrackName1.getText());
                            Criteria c1 = ses.createCriteria(Artists.class);
                            c1.add(Restrictions.like("art_name", insArtName.getText()));
                            Artists art = (Artists) c1.uniqueResult();
                            alb.setArtist(art);
                            ses.save(alb);
                            track.setAlb(alb);
                            track.setArtist(art);
                            ses.save(track);
                            aList.add(alb.getAlb_title());
                            aInvObsArr.add(alb.getAlb_id());
                            tList.add(track.getTrack_title());
                            tInvObsArr.add(track.getTrack_id());
                            tr.commit();
                            ses.close();
                            fact.close();
                            st.close();
                        }

                    }
                });
                                box1.setAlignment(Pos.CENTER);

                box3.setAlignment(Pos.CENTER);
                box4.setAlignment(Pos.CENTER);
                box5.setAlignment(Pos.CENTER); 
                artAlbBox.setAlignment(Pos.CENTER);
                Scene sc = new Scene(artAlbBox, 470, 350);
                artAlbBox.setId("box");
                sc.getStylesheets().add(getClass().getResource("newCascadeStyleSheet.css").toExternalForm());
                st.setScene(sc);
                st.show();
                tr.commit();
                ses.close();
                fact.close();
            }
        });
        aDeleteAlbumBtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                SessionFactory fact = configuration.buildSessionFactory();
                Session ses = fact.openSession();
                Transaction tr = ses.beginTransaction();
                Criteria c = ses.createCriteria(Albums.class);
                c.add(Restrictions.like("alb_id", ainvListView.getSelectionModel().getSelectedItem()));
                Albums alb = (Albums) c.uniqueResult();
                List<Tracks> trs = alb.getTracks();
                if (!trs.isEmpty()) {
                    Criteria c1 = ses.createCriteria(Tracks.class);
                    List<Tracks> trs2 = c1.list();
                    int i = 0;
                    int j = 0;
                    while (i < trs2.size()) {
                        while (j < trs.size()) {
                            if (trs2.get(i).getTrack_id() == trs.get(j).getTrack_id()) {
                                ses.delete(trs.get(j));
                                j++;
                            }
                            i++;
                        }

                    }

                }
                setTrList(ses);
                setTrList(ses);
                aInvObsArr.remove(ainvListView.getSelectionModel().getSelectedIndex());
                aList.remove(aListView.getSelectionModel().getSelectedIndex());

                ses.delete(alb);

                tr.commit();
                ses.close();
                fact.close();
            }
        });
        aAddInfBtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                if (!ainfoListView.getItems().isEmpty()) {
                    Stage addtoPlaylistStage = new Stage();
                    final Button selectPlaylistButton = new Button("Wybierz Playliste");
                    ObservableList<String> asd = FXCollections.observableArrayList();
                    final ListView<String> asdListView = new ListView<>();
                    SessionFactory fact = configuration.buildSessionFactory();
                    Session ses = fact.openSession();
                    Transaction tr = ses.beginTransaction();
                    Criteria c = ses.createCriteria(Tracks.class);
                    c.add(Restrictions.like("track_title", ainfoListView.getSelectionModel().getSelectedItem()));
                    Tracks track1 = (Tracks) c.uniqueResult();
                    System.out.println(track1.getTrack_title());
                    Criteria c1 = ses.createCriteria(Playlists.class);
                    List<Playlists> play = c1.list();
                    String[] arr = new String[play.size()];
                    int i = 0;
                    for (Playlists p : play) {
                        arr[i] = p.getPlay_name();
                        i++;
                    }
                    asd.addAll(arr);
                    asdListView.setItems(asd);
                    selectPlaylistButton.setOnAction(new EventHandler<ActionEvent>() {

                        @Override
                        public void handle(ActionEvent t) {
                            SessionFactory fact = configuration.buildSessionFactory();
                            Session ses = fact.openSession();
                            Transaction tr = ses.beginTransaction();
                            Criteria c = ses.createCriteria(Playlists.class);
                            c.add(Restrictions.like("play_name", asdListView.getSelectionModel().getSelectedItem()));
                            Playlists play = (Playlists) c.uniqueResult();
                            List<Tracks> trq = play.getTracks();
                            trq.add(track1);
                            play.setTracks(trq);
                            ses.update(play);
                            tr.commit();
                            ses.close();
                            fact.close();
                        }
                    });
                    HBox box = new HBox(10);
                    box.getChildren().addAll(asdListView, selectPlaylistButton);
                    box.setId("box");
                    Scene sc = new Scene(box, 500, 300);
                    sc.getStylesheets().add(getClass().getResource("newCascadeStyleSheet.css").toExternalForm());
                    addtoPlaylistStage.setScene(sc);
                    addtoPlaylistStage.show();
                    tr.commit();
                    ses.close();
                    fact.close();
                }

            }
        });

        listView1.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> ov, String t, String t1) {
                invListView.getSelectionModel().select(listView1.getSelectionModel().getSelectedIndex());
                invListView.getFocusModel().focus(listView1.getSelectionModel().getSelectedIndex());
            }
        });
        pPlayButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                invList.clear();
                olist.clear();
                SessionFactory fact = configuration.buildSessionFactory();
                Session ses = fact.openSession();
                Transaction tr = ses.beginTransaction();

                Criteria c = ses.createCriteria(Playlists.class);
                c.add(Restrictions.like("play_name", pListView.getSelectionModel().getSelectedItem()));
                Playlists play = (Playlists) c.uniqueResult();
                List<Tracks> tra = play.getTracks();

                for (Tracks k : tra) {
                    olist.add(k.getTrack_title());
                    invList.add(k.getTrack_id());
                }
                invListView.setItems(invList);
                listView1.setItems(olist);

                removeTrack.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent t) {

                        SessionFactory fact = configuration.buildSessionFactory();
                        Session ses = fact.openSession();
                        Transaction tr = ses.beginTransaction();
                        Criteria c1 = ses.createCriteria(Tracks.class);
                        c1.add(Restrictions.like("track_id", invListView.getSelectionModel().getSelectedItem()));
                        Tracks tra = (Tracks) c1.uniqueResult();
                        List<Tracks> listTra = play.getTracks();
                        List<Tracks> Lt1 = new ArrayList<Tracks>();
                        olist.clear();
                        invList.clear();
                        for (Tracks k : listTra) {
                            if (k.getTrack_id() != tra.getTrack_id()) {
                                Lt1.add(k);
                                invList.add(k.getTrack_id());
                                olist.add(k.getTrack_title());
                            }

                        }
                        invListView.setItems(invList);
                        listView1.setItems(olist);

                        play.setTracks(Lt1);
                        ses.update(play);
                        tr.commit();
                        ses.close();
                        fact.close();
                    }
                });

                tr.commit();
                ses.close();
                fact.close();
            }
        });
        pCreatePlaylistButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                createPlaylist();
            }
        });
        pAddToPlaylistButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                SessionFactory fact = configuration.buildSessionFactory();
                Session ses = fact.openSession();
                Transaction tr = ses.beginTransaction();
                Criteria c = ses.createCriteria(Playlists.class);
                c.add(Restrictions.like("play_name", pListView.getSelectionModel().getSelectedItem()));
                Playlists p = (Playlists) c.uniqueResult();
                ses.delete(p);

                pList.remove(pListView.getSelectionModel().getSelectedIndex());
                tr.commit();
                ses.close();
                fact.close();
            }
        });
        pAddToFavourites.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                //HibernateData();
            }
        });

        scene = new Scene(root, 950, 750);
        scene.getStylesheets().add(getClass().getResource("newCascadeStyleSheet.css").toExternalForm());
        stage.setTitle("Audio");
        stage.setScene(scene);

        stage.show();

    }

    public void HibernateData() {
        SessionFactory fact = configuration.buildSessionFactory();
        Session ses = fact.openSession();
        Transaction tr = ses.beginTransaction();
        Artists art1 = new Artists("Hunter", "default");
        Albums alb1 = new Albums("Imperium", 2013);
        Tracks track1 = new Tracks("Imperium Uboju");
        // Playlists play1 = new Playlists("Default");
        track1.setArt(art1);
        track1.setAlb(alb1);

        ses.save(art1);
        ses.save(alb1);
        ses.save(track1);

        tr.commit();

        ses.close();
        fact.close();

        // session.save(play1);
    }

    public void setArtList(Session session) {
        int i = 0;
        //minvListView.setVisible(false);
        Criteria c = session.createCriteria(Artists.class);
        List<Artists> art = c.list();
        String[] artList = new String[art.size()];
        int[] n = new int[art.size()];
        for (Artists ar : art) {
            System.out.println(ar.getArt_name());
            mInvObsArr.add(ar.getArt_id());
            artList[i] = ar.getArt_name();
            i++;
        }
        minvListView.setItems(mInvObsArr);
        mList.addAll(artList);
        mListView.setItems(mList);

    }

    public void setAlbList(Session session) {
        int i = 0;
        aInvObsArr.clear();
        aList.clear();
        Criteria c = session.createCriteria(Albums.class);
        List<Albums> alb = c.list();
        String[] albList = new String[alb.size()];
        for (Albums al : alb) {
            System.out.println(al.getAlb_title());
            aInvObsArr.add(al.getAlb_id());
            albList[i] = al.getAlb_title();
            i++;
        }
        ainvListView.setItems(aInvObsArr);
        aList.addAll(albList);
        aListView.setItems(aList);
    }

    public void setTrList(Session session) {
        int i = 0;
        tInvObsArr.clear();
        tList.clear();
        Criteria c1 = session.createCriteria(Tracks.class);
        List<Tracks> trac = c1.list();
        int[] n = new int[trac.size()];
        String[] traList = new String[trac.size()];
        for (Tracks tr : trac) {
            System.out.println(tr.getTrack_title());
            tInvObsArr.add(tr.getTrack_id());
            traList[i] = tr.getTrack_title();
            i++;
        }
        tinvListView.setItems(tInvObsArr);
        tList.addAll(traList);
        tListView.setItems(tList);
    }

    public void setPlayList(Session session) {
        int i = 0;
        Criteria c1 = session.createCriteria(Playlists.class);
        List<Playlists> play = c1.list();
        String[] playList = new String[play.size()];
        for (Playlists pl : play) {
            System.out.println(pl.getPlay_name());

            playList[i] = pl.getPlay_name();
            i++;
        }

        pList.addAll(playList);
        pListView.setItems(pList);
    }

    public String[] getAllPlaylists(Session session) {
        int i = 0;
        Criteria c1 = session.createCriteria(Playlists.class);
        List<Playlists> play = c1.list();
        String[] playList = new String[play.size()];
        for (Playlists pl : play) {
            System.out.println(pl.getPlay_name());

            playList[i] = pl.getPlay_name();
            i++;
        }
        return playList;
    }

    public void setMusicianDisplay() {
        pane.setPrefWidth(300);
        minvListView.setPrefWidth(1);
        mListView.setPrefWidth(400);
        mListBox.getChildren().addAll(minvListView, mListView);
        mButtonBox.getChildren().addAll(mPlayButton, mAddToPlaylistButton, mCreatePlaylistButton, mAddToFavourites, mCreateArt, mDelArt);
        mInfoBox.getChildren().addAll(mArtLab, minfoListView);
        mMenuBox.getChildren().addAll(mAddInfBtn, mPlayBtn);
        mConBox2.getChildren().addAll(mInfoBox, mMenuBox);
        mSearchBox.getChildren().addAll(mButtonBox, mConBox2);
        mConcatBox.getChildren().addAll(mListBox, mSearchBox);
        musician.setContent(mConcatBox);
    }

    public void setTrackDisplay() {
        tinvListView.setVisible(false);
        tinvListView.setPrefWidth(20);
        tListView.setPrefWidth(400);
        tListBox.getChildren().addAll(tinvListView, tListView);
        tButtonBox.getChildren().addAll(tPlayButton, tAddToPlaylistButton, tCreatePlaylistButton, tAddToFavourites, tAddTrackBBtn, tDeleteTrackBtn);
        tInfoBox.getChildren().addAll(tArtLab, tAlbLab, tPlayButton);

        tSearchBox.getChildren().addAll(tButtonBox, tInfoBox);
        tConcatBox.getChildren().addAll(tListBox, tSearchBox);
        track.setContent(tConcatBox);
    }

    public void setDisplay() {
        pane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        pane.getTabs().addAll(musician, track, album, playlist);
        root.getChildren().addAll(pane,playBtnBox);
        playBtnBox.getChildren().add(prevTr);
        sliderBox.getChildren().add(nextButton);
        nextButton.setVisible(false);
        prevTr.setVisible(false);
        playBtnBox.setPrefHeight(20);

        setMusicianDisplay();
        setTrackDisplay();
        setAlbumDisplay();
        setPlaylistDisplay();
        setCSS();
    }

    public void setAlbumDisplay() {
        pListView.setPrefWidth(400);
        ainvListView.setPrefWidth(1);
        aListView.setPrefWidth(400);
        ainvListView.setVisible(false);
        aListBox.getChildren().addAll(ainvListView, aListView);
        aButtonBox.getChildren().addAll(aAddToFavourites, aAddToPlaylistButton, aCreatePlaylistButton, aAddAlbumBBtn, aDeleteAlbumBtn);
        aInfoBox.getChildren().addAll(aArtLab, ainfoListView);
        aMenuBox.getChildren().addAll(aAddInfBtn);
        aConBox2.getChildren().addAll(aInfoBox, aMenuBox);
        aSearchBox.getChildren().addAll(aButtonBox, aConBox2);
        aConcatBox.getChildren().addAll(aListBox, aSearchBox);
        album.setContent(aConcatBox);
    }

    public void setPlaylistDisplay() {
        invListView.setPrefWidth(1);
        invListView.setVisible(false);
        ptrBtnBox.getChildren().addAll(removeTrack);
        pTrackBox.getChildren().addAll(invListView, listView1, ptrBtnBox);
        pSearchBox.getChildren().addAll(pButtonBox, pTrackBox);
        pListBox.getChildren().addAll(stopBtn,pListView);
        pButtonBox.getChildren().addAll(pPlayButton, pAddToPlaylistButton, pCreatePlaylistButton);
        pConcatBox.getChildren().addAll(pListBox, pSearchBox);
        playlist.setContent(pConcatBox);
    }

    public void createPlaylist() {
        Stage createPlaylistStage = new Stage();
        final TextField EnterPlaylistName = new TextField();
        final Button enterButton = new Button("Utwórz");
        Label playlistLabel = new Label("Wprowadź nazwę: ");
        HBox newPlaylistBox = new HBox(10);
        newPlaylistBox.getChildren().addAll(stopBtn,playlistLabel, EnterPlaylistName, enterButton);
        enterButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                SessionFactory fact = configuration.buildSessionFactory();
                Session ses = fact.openSession();
                Transaction tr = ses.beginTransaction();
                Playlists newPlaylist = new Playlists(EnterPlaylistName.getText());

                ses.save(newPlaylist);
                pList.add(newPlaylist.getPlay_name());
                pListView.setItems(pList);
                tr.commit();
                ses.close();
                fact.close();
            }

        });
        Scene newPlaylistScene = new Scene(newPlaylistBox, 530, 100);
        newPlaylistBox.setId("box");
        newPlaylistScene.getStylesheets().add(getClass().getResource("newCascadeStyleSheet.css").toExternalForm());
        createPlaylistStage.setScene(newPlaylistScene);
        createPlaylistStage.show();
    }

    public void addToPlaylistM(List<Tracks> tracks2, ListView<String> asdListView, Button b) {
        b.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                SessionFactory fact = configuration.buildSessionFactory();
                Session ses = fact.openSession();
                Transaction tr = ses.beginTransaction();

                Criteria c3 = ses.createCriteria(Playlists.class);
                c3.add(Restrictions.like("play_name", asdListView.getSelectionModel().getSelectedItem()));
                Playlists play = (Playlists) c3.uniqueResult();
                List<Tracks> mt = play.getTracks();
                mt.addAll(tracks2);
                play.setTracks(mt);
                ses.update(play);
                tr.commit();
                ses.close();
                fact.close();
            }
        });

    }

    public void setCSS() {
        musician.setId("musician");
        root.setId("root");
    }

}
