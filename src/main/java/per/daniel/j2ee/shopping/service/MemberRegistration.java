package per.daniel.j2ee.shopping.service;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import java.util.logging.Logger;

import org.hibernate.Session;

import per.daniel.j2ee.shopping.model.Member;

@Stateless
public class MemberRegistration {

    @Inject
    private Logger log;

    @Inject
    private EntityManager em;

    @Inject
    private Event<Member> memberEventSrc;

    public void register(Member member) throws Exception {
        log.info("Registering " + member.getName());
        // em.persist(member);

        // using Hibernate session(Native API) and JPA entitymanager
        Session session = (Session) em.getDelegate();
        session.persist(member);
        memberEventSrc.fire(member);
    }
}
