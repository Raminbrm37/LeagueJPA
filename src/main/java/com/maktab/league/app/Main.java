package com.maktab.league.app;

import com.maktab.league.dao.impldao.PlayerDao;
import com.maktab.league.dao.impldao.TeamDao;
import com.maktab.league.dao.impldao.TransferDao;
import com.maktab.league.domain.*;
import com.maktab.league.domain.enumclasses.Position;

import javax.persistence.EntityManager;
import java.util.Date;

import static com.maktab.league.util.JpaUtil.getEntityManagerFactory;
import static com.maktab.league.util.JpaUtil.shutDown;

public class Main {
    public static void init(EntityManager entityManager) {
        Player player = new Player();
        player.setFirstName("ramin");
        player.setLastName("brm");
        player.setNationalCode("3860645153");
        player.setBirthDay(new Date(94, 3, 19));
        player.setPosition(Position.FORWARD);
        Player player1 = new Player();
        player1.setFirstName("ali");
        player1.setLastName("alavi");
        player1.setNationalCode("3860645155");
        player1.setBirthDay(new Date(97, 3, 19));
        player1.setPosition(Position.GOAL_KEEPER);
        Player player2 = new Player();
        player2.setFirstName("javad");
        player2.setLastName("raeisi");
        player2.setNationalCode("3860645177");
        player2.setBirthDay(new Date(97, 3, 19));
        player2.setPosition(Position.MIDFIELDER);


        Team team = Team.teamBuilder()
                .name("esteghlal")
                .build();
        Team team1 = Team.teamBuilder()
                .name("pirozi")
                .build();
        Team team2 = Team.teamBuilder()
                .name("sepahan")
                .build();
        Coach coach = new Coach();
        coach.setFirstName("adadad");
        coach.setLisance("A");
        coach.setNationalCode("7891231235");
        entityManager.getTransaction().begin();
        entityManager.persist(coach);
        entityManager.persist(player);
        entityManager.persist(player1);
        entityManager.persist(player2);
        entityManager.persist(team);
        entityManager.persist(team1);
        entityManager.persist(team2);


        entityManager.getTransaction().commit();

        Transfer transfer = new Transfer();
        transfer.setSeason(2020);
        transfer.setDuration(1);
        transfer.setTeam(team);
        transfer.setUser(player);
        Transfer transfer1 = new Transfer();
        transfer1.setSeason(2020);
        transfer1.setDuration(1);
        transfer1.setTeam(team);
        transfer1.setUser(coach);
        Transfer transfer2 = new Transfer();
        transfer2.setUser(player2);
        transfer2.setSeason(2020);
        Transfer transfer3 = new Transfer();
        transfer3.setSeason(2020);
        transfer3.setUser(player1);
        transfer3.setTeam(team2);


        entityManager.getTransaction().begin();

        entityManager.persist(transfer);
        entityManager.persist(transfer1);
        entityManager.persist(transfer2);
        entityManager.persist(transfer3);
        entityManager.getTransaction().commit();
//        Team team = entityManager.find(Team.class, 1L);
//        Team team1 = entityManager.find(Team.class, 2L);
//        User player = entityManager.find(User.class, 3L);
        entityManager.getTransaction().begin();


        Matchs matchs = new Matchs();
        matchs.setHomeTeam(team);
        matchs.setAwayTeam(team1);
        entityManager.getTransaction().commit();

        entityManager.getTransaction().begin();
        MatchInformation matchInformation = new MatchInformation();

        matchInformation.setPlayer(player1);
        matchInformation.setMatchs(matchs);
        entityManager.persist(matchs);
        //  matchInformation.save(entityManager, matchInformation);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    // init(entityManager);
//        TeamDao teamDao = new TeamDao(entityManager);
//        PlayerDao playerDao = new PlayerDao(entityManager);
//        UserDao userDao = new UserDao(entityManager);
//        TransferDao transferDao = new TransferDao(entityManager);
//        MatchsDao md = new MatchsDao(entityManager);
//        Matchs matchs = md.loadById(1L);
//        Player player = playerDao.loadById(2L);
//        CoachDao coachDao = new CoachDao(entityManager);
//        Transfer transfer = transferDao.loadById(2020, 2L);
//        //  User player=userDao.loadById(2L);
//        Player javad = playerDao.loadById(4L);
//        MatchInfoDao matchInfoDao = new MatchInfoDao(entityManager);
//        // MatchInformation m2 = entityManager.find(MatchInformation.class, new MatchInformationId(player, matchs));
//        MatchInformation m1 = matchInfoDao.loadById(3L, 1L);
//        Team team = teamDao.loadById(1L);
//        System.out.println(team.getName());
//        System.out.println(player.getFirstName());
//        System.out.println(transfer.getIsActive());
//        System.out.println(m1.getNumberOfGoal());
//        MatchInformation matchInformation = MatchInformation.builder()
//                .matchs(matchs)
//                .player(javad)
//                .build();
    public static void main(String[] args) {

        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        PlayerDao playerDao = new PlayerDao(entityManager);
        TransferDao transferDao = new TransferDao(entityManager);
        TeamDao teamDao = new TeamDao(entityManager);
        entityManager.getTransaction().begin();
//        Player player = new Player();
//        player.setFirstName("amir");
//        player.setLastName("amiri");
//        player.setNationalCode("3860645100");
//        player.setPosition(Position.MIDFIELDER);
//        player.setBirthDay(new Date(94, 12, 28));
//        playerDao.save(player);
        Player player1 = playerDao.loadById(5L);
        Team team = teamDao.loadById(1L);
        Transfer transfer = Transfer.builder()
                .duration(1)
                .season(2020)
                .salary(1568.6)
                .user(player1)
                .team(team)
                .build();
        transferDao.save(transfer);
        entityManager.getTransaction().commit();

        shutDown();

    }


}
