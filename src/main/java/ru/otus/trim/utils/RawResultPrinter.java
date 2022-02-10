package ru.otus.trim.utils;

import org.bson.Document;

public interface RawResultPrinter {
    @SuppressWarnings("unchecked")
    void prettyPrintRawResult(Document document);
}
