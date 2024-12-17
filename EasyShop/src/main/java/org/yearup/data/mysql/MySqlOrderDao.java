package org.yearup.data.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.yearup.data.OrderDao;
import org.yearup.data.UserDao;
import org.yearup.models.Order;

import javax.sql.DataSource;
import java.sql.*;

@Component
public class MySqlOrderDao extends MySqlDaoBase implements OrderDao {
    @Autowired
    public MySqlOrderDao(DataSource dataSource) {
        super(dataSource);

    }


    @Override
    public Order create(Order order) {
        String sql = "INSERT INTO orders (user_id, date, address, city, state, zip, shipping_amount) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, order.getUserId());
            statement.setDate(2, order.getDate());
            statement.setString(3, order.getAddress());
            statement.setString(4, order.getCity());
            statement.setString(5,order.getState());
            statement.setString(6,order.getZip());
            statement.setBigDecimal(7,order.getShippingAmount());

            int rows = statement.executeUpdate();

            if(rows==0)throw new SQLException("Failed to create order");

            try(ResultSet generatedKeys = statement.getGeneratedKeys()){
                if(generatedKeys.next()){
                    int generatedId = generatedKeys.getInt(1);
                    order.setOrderId(generatedId);
                    return order;
                }

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
