package org.yearup.data.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.yearup.data.OrderLineItemDao;
import org.yearup.models.Order;
import org.yearup.models.OrderLineItem;
import org.yearup.models.ShoppingCart;

import javax.sql.DataSource;
import java.sql.*;

@Component
public class MySqlOrderLineItemDao extends MySqlDaoBase implements OrderLineItemDao {
    @Autowired
    public MySqlOrderLineItemDao(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public OrderLineItem create(OrderLineItem orderItem) {
        String sql = "INSERT INTO order_line_items (order_id, product_id, sales_price, quantity, discount) VALUES (?,?,?,?,?)";

        try(Connection connection = getConnection()){
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1,orderItem.getOrderId());
            statement.setInt(2,orderItem.getProductId());
            statement.setBigDecimal(3,orderItem.getPrice());
            statement.setInt(4,orderItem.getQuantity());
            statement.setBigDecimal(5,orderItem.getDiscount());
            int rows = statement.executeUpdate();

            if(rows==0)throw new SQLException("Failed to add product");

            try(ResultSet generatedKeys = statement.getGeneratedKeys()){
                if(generatedKeys.next()){
                    int generatedId = generatedKeys.getInt(1);
                    orderItem.setLineItemId(generatedId);
                    return orderItem;
                }

            }

        }catch(Exception e){
            throw new RuntimeException("Error adding to cart", e);
        }
        return null;
    }
}
