package com.talent.exchange.demo.dao.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.UUID;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.talent.exchange.demo.dao.TalentExchangeDemoDao;
import com.talent.exchange.demo.model.MoAddress;
import com.talent.exchange.demo.model.MoBase;
import com.talent.exchange.demo.model.MoUser;
import com.talent.exchange.demo.model.MoUserEnum.ADDRESS_TYPE;
import com.talent.exchange.demo.model.MoUserEnum.APPROVAL_STATUS;
import com.talent.exchange.demo.model.MoUserEnum.GENDER;
import com.talent.exchange.demo.model.MoUserEnum.MEDIA_CATEGORY;
import com.talent.exchange.demo.model.MoUserEnum.USER_ACCOUNT_STATUS;
import com.talent.exchange.demo.model.MoUserEnum.USER_TYPE;
import com.talent.exchange.demo.model.MoUserEnum.VIDEO_CATEGORY;
import com.talent.exchange.demo.model.MoUserProfile;
import com.talent.exchange.demo.model.MoEventContent;
import com.talent.exchange.demo.model.MoVideoUserAction;

@Repository
@Transactional
public class TalentExchangeDemoDaoImpl implements TalentExchangeDemoDao {

	private static final Logger logger = LoggerFactory.getLogger(TalentExchangeDemoDaoImpl.class);

	static Date currentDate = new Date();
	static String IMPRESSICO = "@impressico.com";
	static String DOT = ".";
	static String MOBILE = "9891405493";
	static String PHONE = "0120-4190000";
	static String RANDOM_SALT = "IMPRESSICO";
	static String FB_URL = "https://www.facebook.com/DenzelOfficialFanPage/";
	static String TWITTER_URL = "https://twitter.com/denzelwn";
	static String INSTAGRAM_URL = "https://www.instagram.com/officialdenzel";
	static String IMDB_URL = "http://www.imdb.com/name/nm0000243/";
	static String WIKISITE_URL = "https://en.wikipedia.org/wiki/Denzel_Washington";

	protected final SessionFactory sessionFactory;

	public TalentExchangeDemoDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public String save(MoBase moBase) {
		Date now = new Date();
		if (Objects.nonNull(moBase.getCreationDate())) {
			moBase.setCreationDate(now);
		}
		if (Objects.nonNull(moBase.getLastModificationDate())) {
			moBase.setLastModificationDate(now);
		}
		return (String) sessionFactory.getCurrentSession().save(moBase);
	}

	@Override
	public void update(MoBase moBase) {
		moBase.setLastModificationDate(new Date());
		sessionFactory.getCurrentSession().update(moBase);

	}

	@Override
	public void merge(MoBase moBase) {
		moBase.setLastModificationDate(new Date());
		sessionFactory.getCurrentSession().merge(moBase);
	}

	@Override
	public void saveOrUpdate(MoBase moBase) {
		Date now = new Date();
		if (moBase.getCreationDate() == null) {
			moBase.setCreationDate(now);
		}
		moBase.setLastModificationDate(now);
		sessionFactory.getCurrentSession().saveOrUpdate(moBase);
	}

	@Override
	public void sampleData() {
		save();
	}

	@Override
	public <T> T findById(Class<T> className, Serializable id) {
		return sessionFactory.getCurrentSession().get(className, id);
	}

	@Override
	public List findBy(Class classObj, Map propertyMap, String orderKey, boolean asc) {
		return findBy(classObj, propertyMap, orderKey, asc, -1, -1);
	}

	@Override
	public List findBy(Class classObj, Map propertyMap, String orderKey, boolean asc, int pageSize, int pageNum) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(classObj);
		if (propertyMap != null) {
			for (Object o : propertyMap.entrySet()) {
				Entry entry = (Entry) o;
				criteria.add(Restrictions.eq((String) entry.getKey(), entry.getValue()));
			}
		}
		if (orderKey != null) {
			if (Boolean.TRUE == asc) {
				criteria.addOrder(Order.asc(orderKey));
			} else {
				criteria.addOrder(Order.desc(orderKey));
			}
		}
		if (pageSize > 0) {
			criteria.setMaxResults(pageSize);
			if (pageNum > 0) {
				criteria.setFirstResult((pageNum - 1) * pageSize);
			}

		}
		return criteria.list();
	}

	@Override
	public List findByQuery(String queryStr) {
		Query query = sessionFactory.getCurrentSession().createQuery(queryStr);
		return query.list();
	}

	@Override
	public Query createQuery(String queryStr) {
		return sessionFactory.getCurrentSession().createQuery(queryStr);
	}

	@Override
	public List<?> findByNamedQuery(String namedQuery, Map<String, Object> params) {
		return findByNamedQuery(namedQuery, params, 0, 0);
	}

	@Override
	public List findByNamedQuery(String namedQuery, Map<String, Object> params, int pageSize, int pageNumber) {
		Query query = getQuery(namedQuery, params);
		if (pageSize > 0) {
			query.setMaxResults(pageSize);
			if (pageNumber > 0) {
				query.setFirstResult((pageNumber - 1) * pageSize);
			}
		}
		return query.list();
	}

	@Override
	public MoBase findUniqueByCriteria(Class classObj, Map<String, Object> params) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(classObj);
		if (params != null) {
			for (Map.Entry<String, Object> param : params.entrySet()) {
				criteria.add(Restrictions.eq(param.getKey(), param.getValue()));
			}
		}
		return (MoBase) criteria.uniqueResult();
	}

	@Override
	public MoBase findUniqueByNamedQuery(String namedQuery, Map<String, Object> params) {
		Query query = getQuery(namedQuery, params);
		return (MoBase) query.uniqueResult();
	}

	@Override
	public int updateByNamedQuery(String namedQuery, Map<String, Object> params) {
		Query query = getQuery(namedQuery, params);
		return query.executeUpdate();
	}

	@Override
	public long countByNamedQuery(String namedQuery, Map<String, Object> params) {
		Object obj = executeNamedQuery(namedQuery, params);
		if (obj == null) {
			return 0;
		}
		return ((Number) obj).longValue();
	}

	@Override
	public double calculateByNamedQuery(String namedQuery, Map<String, Object> params) {
		Object countObj = executeNamedQuery(namedQuery, params);
		if (countObj == null) {
			return 0;
		}
		return ((Number) countObj).doubleValue();
	}

	@Override
	public void delete(MoBase moBase) {
		sessionFactory.getCurrentSession().delete(moBase);
	}

	@Override
	public Criteria createCriteria(Class class1) {
		return sessionFactory.getCurrentSession().createCriteria(class1);
	}

	@Override
	public void flush() {
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public Object executeNamedQueryAndGetFirstResult(String queryString, Map<String, Object> params) {
		Query query = getQuery(queryString, params);
		query.setMaxResults(1);
		return query.uniqueResult();
	}

	private Query getQuery(String namedQuery, Map<String, Object> params) {
		Query query = sessionFactory.getCurrentSession().getNamedQuery(namedQuery);
		if (params != null) {
			for (Map.Entry<String, Object> param : params.entrySet()) {
				if (param.getValue() != null && param.getValue() instanceof Collection) {
					query.setParameterList(param.getKey(), (Collection) param.getValue());
				} else {
					query.setParameter(param.getKey(), param.getValue());
				}
			}
		}
		return query;
	}

	private Object executeNamedQuery(String namedQuery, Map<String, Object> params) {
		Query query = getQuery(namedQuery, params);
		Object object = query.uniqueResult();
		return object;
	}

	private void save() {
		logger.info("******* STARTING SAMPLE DATA *************");
		MoUser fan1 = createUser("Nancy", "Drew", GENDER.F, "password1", false, true);
		save(fan1);
		logger.info("Fan 1 Saved");
		MoUser fan2 = createUser("Josh", "Willams", GENDER.M, "password2", false, true);
		save(fan2);
		logger.info("Fan 2 Saved");
		MoUser fan3 = createUser("Anita", "Smith", GENDER.F, "password3", false, true);
		save(fan3);
		logger.info("Fan 3 Saved");

		// we have to save these Fans

		MoUser artist1 = createUser("John", "Mclane", GENDER.M, "password4", true, false);
		save(artist1);
		logger.info("Artist 1 Saved");
		MoUser artist2 = createUser("Celina", "Fredick", GENDER.F, "password5", true, false);
		save(artist2);
		logger.info("Artist 2 Saved");
		MoUser artist3 = createUser("Bill", "Johnson", GENDER.M, "password6", true, false);
		save(artist3);
		logger.info("Artist 3 Saved");
		MoUser artist4 = createUser("Sudhir", "Rathi", GENDER.M, "password6", true, false);
		save(artist4);
		logger.info("Artist 4 Saved");

		// we have to save these Artists

		MoEventContent video1 = createVideo(artist1, "Video 1", "Video 1", "Talent Exchange Video 1 Decsription", null,
				"Talent Exchange Video 1");
		save(video1);
		logger.info("Video 1 Saved");

		MoEventContent video2 = createVideo(artist1, "Video 2", "Video 2", "Talent Exchange Video 2 Descritpion", null,
				"Talent Exchange Video 2");
		save(video2);
		logger.info("Video 2 Saved");

		MoEventContent video3 = createVideo(artist2, "Video 3", "Video 3", "Talent Exchange Video 3 Decsription", null,
				"Talent Exchange Video 3");
		save(video3);
		logger.info("Video 3 Saved");

		MoEventContent video4 = createVideo(artist2, "Video 4", "Video 4", "Talent Exchange Video 4 Decsription", null,
				"Talent Exchange Video 4");
		save(video4);
		logger.info("Video 4 Saved");

		MoEventContent video5 = createVideo(artist3, "Video 5", "Video 5", "Talent Exchange Video 5 Decsription", null,
				"Talent Exchange Video 5");
		save(video5);
		logger.info("Video 5 Saved");

		MoEventContent video6 = createVideo(artist3, "Video 6", "Video 6", "Talent Exchange Video 6 Decsription", null,
				"Talent Exchange Video 6");
		save(video6);
		logger.info("Video 6 Saved");

		MoEventContent video7 = createVideo(artist4, "Video 7", "Video 7", "Talent Exchange Video 7 Decsription", null,
				"Talent Exchange Video 7");
		save(video7);
		logger.info("Video 7 Saved");

		MoEventContent video8 = createVideo(artist4, "Video 8", "Video 8", "Talent Exchange Video 8 Decsription", null,
				"Talent Exchange Video 8");
		save(video8);
		logger.info("Video 8 Saved");
		logger.info("******* SAMPLE DATA FINISHED *************");
	}

	private static MoUser createUser(String firstName, String lastName, GENDER g, String password, boolean isArtist,
			boolean isFan) {
		MoUser fan = new MoUser();
		fan.setAcceptedTermsOfUsage(true);
		fan.setAccountStatus(USER_ACCOUNT_STATUS.ACTIVE);
		fan.setAddress(getAdress());
		fan.setArtist(isArtist);
		fan.setInvestor(false);
		fan.setFan(isFan);

		if (isArtist) {
			fan.setAuthType(USER_TYPE.ARTIST);
			fan.setTalent(true);
		}

		if (isFan) {
			fan.setAuthType(USER_TYPE.FAN);
			fan.setTalent(false);
		}

		fan.setCreationDate(currentDate);
		fan.setDeleted(false);
		fan.setDialcode("0120");
		fan.setEmail(firstName + DOT + lastName + IMPRESSICO);
		fan.setEmailVerified(true);
		fan.setFirstName(firstName);
		fan.setGender(g);
		fan.setLastModificationDate(currentDate);
		fan.setLastName(lastName);
		fan.setLocale("US-EN");
		fan.setMobile(MOBILE);
		fan.setPassword(password);
		fan.setPhone(PHONE);
		fan.setRandomSalt(RANDOM_SALT);
		fan.setResetPassword(true);

		fan.setUserName(firstName + DOT + lastName);
		fan.setVersion(0);
		fan.setUserProfile(getUserProfile(fan));
		fan.setToken(UUID.randomUUID().toString());
		return fan;
	}

	private static MoVideoUserAction commentRateEndorseFollow(MoEventContent video, MoUser fan, String comment,
			boolean isEndorsed, boolean isFollowing, int rating) {
		MoVideoUserAction videoUserAction = new MoVideoUserAction();
		videoUserAction.setComment(comment);
		videoUserAction.setCreationDate(currentDate);
		videoUserAction.setEndorse(isEndorsed);
		videoUserAction.setFollowing(isFollowing);
		videoUserAction.setLastModificationDate(currentDate);
		videoUserAction.setRating(rating);
		videoUserAction.setUserFan(fan);
		videoUserAction.setVersion(0);
		videoUserAction.setVideo(video);
		return videoUserAction;
	}

	private static MoAddress getAdress() {
		MoAddress address = new MoAddress();
		address.setAddressLine1("Impresscio Business Solutions");
		address.setAddressLine2("B-134, Sector-6, Noida, UP, India");
		address.setAddressType(ADDRESS_TYPE.MAILING);
		address.setCity("NOIDA");
		address.setCountry("INDIA");
		address.setCreationDate(currentDate);
		address.setLastModificationDate(currentDate);
		address.setMailCode("201301");
		address.setState("U.P.");
		address.setUSAddress(false);
		address.setVersion(0);
		return address;
	}

	private static MoEventContent createVideo(MoUser artist, String name, String originalName, String videoDesc,
			String videoLogLine, String videoTitle) {
		MoEventContent event = new MoEventContent();
		event.setApprovalStatus(APPROVAL_STATUS.APPROVED);
		event.setArchived(false);
		event.setArtist(artist);
		event.setCreationDate(currentDate);
		event.setEndorsement(100);
		event.setEventImagePath(null);
		event.setEventLogLine(videoLogLine);
		event.setEventTitle(videoTitle);
		event.setEventVideoPath(null);
		event.setFileSize(25);
		event.setLastModificationDate(currentDate);
		event.setLiveVideo(false);
		event.setMediaCategory(MEDIA_CATEGORY.VIDEO);
		event.setVideoCategory(VIDEO_CATEGORY.ACTION);
		event.setMediaId(UUID.randomUUID().toString());
		event.setName(name);
		event.setOriginalFileName(originalName);
		event.setPublished(true);
		event.setPublishedDate(currentDate);
		event.setVersion(0);
		event.setVideoDescription(videoDesc);
		event.setVideoLength(100);
		
		return event;
	}

	private static MoUserProfile getUserProfile(MoUser user) {
		MoUserProfile userProfile = new MoUserProfile();
		userProfile.setCoverImage(null);
		userProfile.setCreationDate(currentDate);
		userProfile.setDisplayLastName(true);
		userProfile.setDonationRecieved(10000000.00);
		userProfile.setFacebookUrl(FB_URL);
		userProfile.setFacebookFollowers(100000L);
		userProfile.setImdbUrl(IMDB_URL);
		userProfile.setInstagramUrl(INSTAGRAM_URL);
		userProfile.setInstagramFollowers(100000L);
		userProfile.setIndustry(1000);
		userProfile.setLastModificationDate(currentDate);
		userProfile.setMoneyEarned(22222.00);
		userProfile.setNumberOfViews(635241);
		userProfile.setProfileImage(null);
		userProfile.setPhotoUrl(null);
		userProfile.setRealTimeTrending(5698544.00);
		userProfile.setStars(265.0);
		userProfile.setTwitterUrl(TWITTER_URL);
		userProfile.setTwitterFollowers(100000L);
		userProfile.setUser(user);
		userProfile.setVersion(0);
		userProfile.setWikiSiteUrl(WIKISITE_URL);
		return userProfile;
	}

}
