package org.projet.dao.impl;

import org.projet.beans.ClientTest;
import org.projet.dao.IClientDao;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class ClientDao extends EntityProjetDaoImp<ClientTest> implements IClientDao {

}
