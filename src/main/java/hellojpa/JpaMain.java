package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
//            생성
//            Member member = new Member();
//            member.setId(2L);
//            member.setName("HelloA");
//            em.persist(member);
//            Select 문
//            Member findMember = em.find(Member.class, 1L);
//            System.out.println("findMember.getId() = " + findMember.getId());
//            System.out.println("findMember.getName() = " + findMember.getName());

//            수정
//            Member findMember = em.find(Member.class, 1L);
//            findMember.setName("HelloJPA");

//            JPQL 예시
//            List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                    .setFirstResult(1)
//                    .setMaxResults(10)
//                    .getResultList();
//            for (Member member : result) {
//                System.out.println("member.getName() = " + member.getName());
//            }
            // 비영속상태
//            Member member = new Member();
//            member.setName("HelloJPA");
//            member.setId(101L);
//
//            // 영속상태
//            System.out.println("====BEFORE====");
//            em.persist(member);
//            em.detach(member); // 영속상태 해제
//            System.out.println("====AFTER====");


            // 영속
//            Member member = new Member(200L, "member200");
//            em.persist(member);
//            em.flush();
//
//            System.out.println("===============");

            Member member = em.find(Member.class, 150L);
            member.setName("AAAA");

//            em.detach(member);
            em.clear(); // 1차 캐시 통으로 날려버림

            Member member2 = em.find(Member.class, 150L);

            System.out.println("===============");
            tx.commit(); // Commit 시점에 쿼리 날라감
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
