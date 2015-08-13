package lv.javaguru.java2.database.frontend;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.domain.frontend.Hotel;

import java.util.List;

public interface SearchDAO {

    List<Hotel> searchHotel(String searchSpec) throws DBException;

    List<Hotel> searchHotelByAddress(String searchSpec) throws DBException;

    List<Hotel> searchHotelByDesc(String searchSpec) throws DBException;
}
