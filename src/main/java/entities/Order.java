package entities;

import enums.OrderStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private Date moment;
    private OrderStatus status;
    private Client cliente;

    private List<OrderItem> itens = new ArrayList<>();
    public Order() {
    }

    public Order( OrderStatus status,Client cliente) {
        this.status = status;
        this.cliente = cliente;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Client getCliente() {
        return cliente;
    }

    public void setCliente(Client cliente) {
        this.cliente = cliente;
    }

    public List<OrderItem> getItens(int i) {
        return itens;
    }

    public void addItem(OrderItem item) {
        itens.add(item);
    }

    public void removeItem(OrderItem item){
        itens.remove(item);
    }
    public double total(){
        double sum= 0;
        for(OrderItem c: itens){
            sum += c.subTotal();
        }
        return sum;
    }

}

