package util;

public class OrderedKeyValue implements Comparable<OrderedKeyValue>{
    String key;
    int value;
    @Override
    public int compareTo(OrderedKeyValue other) {

        return key.compareTo(other.key);
    }
    public OrderedKeyValue(String key, int value) {
	this.key = key;
	this.value = value;
    }
    @Override
    public String toString() {
	return "(" + key + ", " + value + ")";
    }
}
