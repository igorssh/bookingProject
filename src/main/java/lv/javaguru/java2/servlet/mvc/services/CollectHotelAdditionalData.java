package lv.javaguru.java2.servlet.mvc.services;

import lv.javaguru.java2.core.database.DBException;
import lv.javaguru.java2.core.domain.frontend.Hotel;

/**
 * Created by Aleksej_home on 2015.09.02..
 */
public interface CollectHotelAdditionalData {

    Hotel processService(String id)throws DBException;

}
