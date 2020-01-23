package dao;

import java.util.ArrayList;

import java.util.List;
import java.util.Set;

import javax.persistence.Query;

import org.hibernate.HibernateException;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import domain.Contact;
import domain.ContactGroup;
import domain.Entreprise;
import domain.IAddress;
import domain.IContact;
import domain.IPhoneNumber;
import domain.PhoneNumber;
import util.HibernateUtil;

public class DAOContact {

	public DAOContact() {

	}

	/*
	 * public void peupler () {
	 * 
	 * ApplicationContext context = new FileSystemXmlApplicationContext(
	 * "Users/eliseeassohoun/eclipse-javaEE/GestionContact/WebContent/WEB-INF/applicationContext.xml"
	 * );
	 * 
	 * IContact contactKadjo = (IContact)context.getBean("idContactKadjo");
	 * 
	 * IPhoneNumber phoneKadjo = (IPhoneNumber) context.getBean("idPhoneKadjo");
	 * IAddress addressKadjo = (IAddress) context.getBean("idAddressKadjo");
	 * 
	 * 
	 * IContact contactCurry = (IContact)context.getBean("idContactCurry");
	 * 
	 * IPhoneNumber phoneCurry = (IPhoneNumber) context.getBean("idPhoneCurry");
	 * IAddress addressCurry = (IAddress) context.getBean("idAddressCurry");
	 * 
	 * 
	 * this.addContactBeans(contactKadjo); }
	 */

	public void addContact(Contact contact, Set<PhoneNumber> pn, Set<ContactGroup> groups) {

		Session session = null;
		Transaction tx = null;

		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			contact.setPhones(pn);
			contact.setGroups(groups);

			for (PhoneNumber p : pn) {

				contact.getPhones().add(p);
				p.setContact(contact);
				session.save(p);
			}

			for (ContactGroup g : groups) {
				contact.getGroups().add(g);
				g.getContacts().add(contact);
				session.save(g);
			}

			session.save(contact);
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*
	 * public void addContactBeans(IContact contact) {
	 * 
	 * Session session = null; Transaction tx = null;
	 * 
	 * try { session = HibernateUtil.getSessionFactory().getCurrentSession(); tx =
	 * session.beginTransaction(); session.save(contact); tx.commit();
	 * 
	 * } catch (Exception e) { e.printStackTrace(); }
	 * 
	 * }
	 */

	public void addEntreprise(Entreprise entreprise, Set<PhoneNumber> pn, Set<ContactGroup> groups, String numSiret) {

		Session session = null;
		Transaction tx = null;

		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			entreprise.setPhones(pn);
			entreprise.setGroups(groups);
			entreprise.setNumSiret(numSiret);

			for (PhoneNumber p : pn) {

				entreprise.getPhones().add(p);
				p.setContact(entreprise);
				session.save(p);
			}

			for (ContactGroup g : groups) {
				entreprise.getGroups().add(g);
				g.getContacts().add(entreprise);
				session.save(g);
			}

			session.save(entreprise);
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void updateContact(IContact contact) {

		Session session = null;
		Transaction tx = null;

		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();

			session.update(contact);
			tx.commit();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void deleteContact(Long id) {

		Session session = null;
		Transaction tx = null;

		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();

			IContact contact = (IContact) session.get(Contact.class, id);
			session.delete(contact);
			tx.commit();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	/*
	 * Get contact from id
	 */

	public IContact getContact(Long id) {

		Session session = null;
		Transaction tx = null;
		IContact contact = null;

		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			contact = (IContact) session.get(Contact.class, id);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return contact;
	}
	/*
	 * Get all Contacts from id
	 */

	public List<Contact> getAllContacts() {

		Session session = null;
		Transaction tx = null;
		List<Contact> listC = null;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			listC = session.createQuery("from Contact").list();
			System.out.println("tableau" + listC.toString());
			tx.commit();

		} catch (Exception e) {

			e.printStackTrace();
		}
		return listC;
	}
}
