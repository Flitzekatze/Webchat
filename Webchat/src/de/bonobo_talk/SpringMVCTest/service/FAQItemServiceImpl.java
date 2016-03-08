package de.bonobo_talk.SpringMVCTest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.bonobo_talk.SpringMVCTest.DAO.FAQItemDAO;
import de.bonobo_talk.SpringMVCTest.model.FAQItem;

@Service("FAQItemService")
@Transactional
public class FAQItemServiceImpl implements FAQItemService {

	@Autowired
	private FAQItemDAO dao;
	
	@Override
	public FAQItem findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public void saveFAQItem(FAQItem faqItem) {
		// TODO Auto-generated method stub
		dao.saveFAQItem(faqItem);
	}

	@Override
	public void deleteFAQItemById(int id) {
		// TODO Auto-generated method stub
		dao.deleteFAQItemById(id);
	}

	@Override
	public List<FAQItem> getAllFAQItems() {
		// TODO Auto-generated method stub
		return dao.getAllFAQItems();
	}

	@Override
	public List<FAQItem> findFAQItemByBetreff(String betreff) {
		// TODO Auto-generated method stub
		return dao.findFAQItemByBetreff(betreff);
	}

	@Override
	public void saveOrUpdateFAQItem(FAQItem faqItem) {
		// TODO Auto-generated method stub
		dao.updateFAQItem(faqItem);
	}

}
