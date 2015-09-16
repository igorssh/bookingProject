package lv.javaguru.java2.core.database.frontend;

import lv.javaguru.java2.core.database.DBException;
import lv.javaguru.java2.core.domain.frontend.Hotel;

import java.util.List;

public interface SearchHotelDAO {

    List<Hotel> searchHotel(String searchSpec) throws DBException;

    List<Hotel> searchHotelByAddress(String searchSpec) throws DBException;

    List<Hotel> searchHotelByDesc(String searchSpec) throws DBException;
}
