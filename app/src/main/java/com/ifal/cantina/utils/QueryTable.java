package com.ifal.cantina.utils;

import de.vandermeer.asciitable.AsciiTable;

import java.util.List;

public class QueryTable {
    private final AsciiTable table = new AsciiTable();

    public QueryTable(List<String> tableTitles) {
        table.addRule();
        table.addRow(tableTitles);
        table.addRule();
    }

    @Override
    public String toString() {
        return table.render();
    }

    public void saveQueryFormat(List<String> columnValues) {
        table.addRow(columnValues);
        table.addRule();
    }
}
