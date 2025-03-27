package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;

public class Test {
    @Test
    public void testInsert() {
        BinarySearchTree<Producto> bst = new BinarySearchTree<>();
        Producto p1 = new Producto(890, 57.0f, 40.0f, "Producto A", "Categoría 1");
        Producto p2 = new Producto(902, 90.0f, 69.0f, "Producto B", "Categoría 2");

        bst.insert(p1);
        bst.insert(p2);

        assertEquals(p1, bst.search(new Producto(101, 0, 0, "", "")));
        assertEquals(p2, bst.search(new Producto(102, 0, 0, "", "")));
        assertNull(bst.search(new Producto(103, 0, 0, "", ""))); // No existe
}
