package org.glavo.liquid;

public final class Variable {
    private Variable() {
    }

    private static final String FilterSeparator = "\\|";
    private static final String ArgumentSeparator = ",";
    private static final String FilterArgumentSeparator = ":";
    private static final String VariableAttributeSeparator = ".";
    private static final String WhitespaceControl = "-";
    private static final String TagStart = "\\{%";
    private static final String TagEnd = "%\\}";
    private static final String VariableSignature = "\\(?[\\w\\-\\.\\[\\]]\\)?";
    private static final String VariableSegment = "[\\w\\-]";
    private static final String VariableStart = "\\{\\{";
    private static final String VariableEnd = "\\}\\}";
    private static final String VariableIncompleteEnd = "\\}\\}?";
    private static final String QuotedString = "\"[^\"]*\"|'[^']*'";
    private static final String QuotedFragment = QuotedString + "|(?:[^\\s,\\|'\"]|" + QuotedString + ")+";
    private static final String TagAttributes = "(\\w+)\\s*\\:\\s*(" + QuotedFragment + ")";
    private static final String AnyStartingTag = TagStart + "|" + VariableStart;
    private static final String PartialTemplateParser = TagStart + ".*?" + TagEnd + "|" + VariableStart + ".*?" + VariableIncompleteEnd + "}";
    private static final String TemplateParser = "(" + PartialTemplateParser + "|" + AnyStartingTag + ")";
    private static final String VariableParser = "\\[[^\\]]+\\]|" + VariableSegment + "+\\??";
}
