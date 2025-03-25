package org.example;

public class BinarySearchTree<E extends Comparable<E>> {

    private Node<E> root;

    // Clase interna Node
    private static class Node<E> {
        E dato;
        Node<E> left;
        Node<E> right;

        Node(E dato) {
            this.dato = dato;
            left = right = null;
        }
    }

    public BinarySearchTree() {
        root = null;
    }


    //se puede crear un objeto temporal con el SKU que ingrese el usuario
    //
    private E searchRec(Node<E> root, E key) {
        if (root == null) {
            return null;
        }

        if (key.compareTo(root.dato) == 0) {
            return root.dato;
        } else if (key.compareTo(root.dato) < 0) {
            return searchRec(root.left, key);
        } else {
            return searchRec(root.right, key);
        }
    }

    private Node<E> insertRec(Node<E> root, E dato) {
        if (root == null) {
            root = new Node<>(dato);
            return root;
        }

        if (dato.compareTo(root.dato) < 0) {
            root.left = insertRec(root.left, dato);
        } else if (dato.compareTo(root.dato) > 0) {
            root.right = insertRec(root.right, dato);
        }

        return root;
    }

    //Insertar elemento
    public void insert(E dato) {
        root = insertRec(root, dato);
    }

    //Buscar un elemento
    public E search(E key) {
        return searchRec(root, key);
    }



}