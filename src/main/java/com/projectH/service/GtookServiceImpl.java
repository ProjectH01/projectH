package com.projectH.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectH.dao.GtookDAO;

@Service
public class GtookServiceImpl implements GtookService {

	@Autowired
	private GtookDAO gtookdao;
}
