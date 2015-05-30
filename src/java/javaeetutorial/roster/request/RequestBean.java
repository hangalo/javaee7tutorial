/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaeetutorial.roster.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javaeetutorial.roster.entity.Player;
import javaeetutorial.roster.entity.Player_;
import javaeetutorial.roster.util.PlayerDetails;
import javax.annotation.PostConstruct;
import javax.ejb.EJBException;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.jboss.logging.Logger;

/**
 *
 * @author desenvolvimento
 */
@Stateful
public class RequestBean implements Serializable {

    private static final Logger logger = Logger.getLogger("roster.request.RequestBean");

    @PersistenceContext
    private EntityManager em;
    private CriteriaBuilder cb;

    @PostConstruct
    private void init() {
        cb = em.getCriteriaBuilder();
    }

    public List<PlayerDetails> getPlayerByPosition(String position) {

        logger.info("getPlayersByPosition");
        List<Player> players = null;
        try {
            CriteriaQuery<Player> cq = cb.createQuery(Player.class);
            if (cq != null) {
                Root<Player> player = cq.from(Player.class);
                cq.where(cb.equal(player.get(Player_.position), position));
                cq.select(player);
                TypedQuery<Player> q = em.createQuery(cq);
                players = q.getResultList();

            }

            return copyPlayersToDetails(players);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }

    }

    private List<PlayerDetails> copyPlayersToDetails(List<Player> players) {
        List<PlayerDetails> detailsList = new ArrayList<>();
        Iterator<Player> i = players.iterator();
        while (i.hasNext()) {
            Player player = (Player) i.next();
            PlayerDetails playerDetails = new PlayerDetails(player.getId(), player.getName(), player.getPosition(), player.getSalary());
            detailsList.add(playerDetails);
        }
        return detailsList;
    }

}
