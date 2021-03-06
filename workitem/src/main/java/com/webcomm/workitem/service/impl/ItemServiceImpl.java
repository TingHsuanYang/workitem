package com.webcomm.workitem.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.webcomm.workitem.model.Item;
import com.webcomm.workitem.model.PccDeveloper;
import com.webcomm.workitem.repository.ItemRepository;
import com.webcomm.workitem.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	ItemRepository repo;

	@Override
	public List<Item> findAll() {
		return repo.findAll(new Sort(Sort.Direction.DESC, "createDate"));
	}

	@Override
	public List<Item> findAllAsc() {
		return repo.findAll(new Sort(Sort.Direction.ASC, "createDate"));
	}

	@Override
	public Item getOne(Long pkItem) {
		return repo.getOne(pkItem);
	}

	@Override
	public Item addOne(Item item) {
		return repo.save(item);
	}

	@Override
	public Date getLastDate() {
		Date d = null;
		Item i = repo.findFirstByOrderByCreateDateDesc();
		if (null != i) {
			d = i.getCreateDate();
		}
		return d;
	}

	@Override
	public Date getStartDate() {
		Date d = null;
		Item i = repo.findFirstByOrderByCreateDateAsc();
		if (null != i) {
			d = i.getCreateDate();
		}
		return d;
	}

	@Override
	public BigDecimal getWorkHours() {
		BigDecimal total = new BigDecimal(0.0);
		List<Item> list = repo.findAll();
		for (Item item : list) {
			total = total.add(item.getWorkTime());
		}
		return total;
	}

	@Override
	public void delete(Item item) {
		repo.delete(item);
	}

	@Override
	public Item update(Item item) {
		return repo.save(item);
	}

	@Override
	public List<Item> findAllBetweenDate(Date startDate, Date endDate) {
		return repo.findByCreateDateBetweenOrderByCreateDateDesc(startDate, endDate);
	}

	@Override
	public List<Item> findAllWithOutDayOff() {
		List<Item> list = repo.findAll(new Sort(Sort.Direction.DESC, "createDate"));

		for (Iterator<Item> iter = list.listIterator(); iter.hasNext();) {
			Item i = iter.next();
			if ("休假事項".equals(i.getCategoryDetail().getDescription())) {
				iter.remove();
			}
		}
		return list;
	}

	@Override
	public List<Item> findAllByPccDeveloperWithOutDayOff(PccDeveloper pccDeveloper) {
		List<Item> list = repo.findByPccDeveloperOrderByCreateDateDesc(pccDeveloper);

		for (Iterator<Item> iter = list.listIterator(); iter.hasNext();) {
			Item i = iter.next();
			if ("休假事項".equals(i.getCategoryDetail().getDescription())) {
				iter.remove();
			}
		}
		return list;
	}

	@Override
	public Date getStartDateByPccDeveloper(PccDeveloper selectedPccDeveloper) {
		Item item = repo.findFirstByPccDeveloperOrderByCreateDateAsc(selectedPccDeveloper);
		if (null == item) {
			return null;
		} else {
			return item.getCreateDate();
		}
	}

	@Override
	public Date getLastDateByPccDeveloper(PccDeveloper selectedPccDeveloper) {
		Item item = repo.findFirstByPccDeveloperOrderByCreateDateDesc(selectedPccDeveloper);
		if (null == item) {
			return null;
		} else {
			return item.getCreateDate();
		}
	}

	@Override
	public BigDecimal getPccDeveloperWorkHours(PccDeveloper selectedPccDeveloper) {
		BigDecimal total = new BigDecimal(0.0);
		List<Item> list = repo.findByPccDeveloper(selectedPccDeveloper);
		for (Item item : list) {
			total = total.add(item.getWorkTime());
		}
		return total;
	}

	@Override
	public List<Item> findAllByPccDeveloper(PccDeveloper selectedPccDeveloper) {
		List<Item> list = repo.findByPccDeveloperOrderByCreateDateDesc(selectedPccDeveloper);
		return list;
	}

	@Override
	public BigDecimal getPccDeveloperWorkHoursAfter(PccDeveloper selectedPccDeveloper, Date date) {
		BigDecimal total = new BigDecimal(0.0);
		List<Item> list = repo.findByPccDeveloperAndCreateDateAfter(selectedPccDeveloper, date);
		for (Item item : list) {
			total = total.add(item.getWorkTime());
		}
		return total;
	}

	@Override
	public void deleteById(long pkItem) {
		repo.deleteById(pkItem);

	}

	@Override
	public List<Item> findAllByPccDeveloper(long userId) {
		return repo.findByPccDeveloper_PkPccDeveloperOrderByCreateDateAsc(userId);
	}

	@Override
	public Date getStartDateByPccDeveloper(long userId) {
		Item item = repo.findFirstByPccDeveloper_PkPccDeveloperOrderByCreateDateAsc(userId);
		if (null != item) {
			return item.getCreateDate();
		} else {
			return null;
		}
	}

	@Override
	public Date getLastDateByPccDeveloper(long userId) {
		Item item = repo.findFirstByPccDeveloper_PkPccDeveloperOrderByCreateDateDesc(userId);
		if (null != item) {
			return item.getCreateDate();
		} else {
			return null;
		}
	}

}
