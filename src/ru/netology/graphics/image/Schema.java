package ru.netology.graphics.image;

public class Schema implements TextColorSchema{
    private final String base = "#$@%*+-'";
    @Override
    public char convert(int color) {
        int index = Math.round(color * (base.length() + 1) / 255);
        return index >= base.length() ? ' ' :base.charAt(index);
    }
}
