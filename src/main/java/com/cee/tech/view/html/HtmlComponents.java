package com.cee.tech.view.html;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class HtmlComponents implements Serializable {
    public static String table(Class<?> clazz,List<?> models) {


        Field[] fields = clazz.getDeclaredFields();

        StringBuilder tbBuilder = new StringBuilder();

        tbBuilder.append("<table>");
        tbBuilder.append("<tr>");

        for (Field field : fields) {
            if(!field.isAnnotationPresent(EticketTableColHeader.class))
                continue;
            tbBuilder.append(" <th>" + field.getAnnotation(EticketTableColHeader.class).headerLabel() + "</th>");
        }

        tbBuilder.append("</tr>");

        if (models == null || models.isEmpty()) {
            return tbBuilder.toString();
        }
        for (Object model : models) {
            tbBuilder.append("<tr>");
            for (Field field : fields) {
                if(!field.isAnnotationPresent(EticketTableColHeader.class))
                    continue;
                field.setAccessible(true);
                try {
                    tbBuilder.append("<td>").append(field.get(model)).append("</td>");

                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }

            tbBuilder.append("</tr>");
        }
        tbBuilder.append("</table>");
        return tbBuilder.toString();
    }

    public static String form(Class<?> model) {


        EticketHtmlForm eticketHtmlForm = null;
        if (model.isAnnotationPresent(EticketHtmlForm.class)) {
            eticketHtmlForm = model.getAnnotation(EticketHtmlForm.class);
        }
        if (eticketHtmlForm == null) {
            return StringUtils.EMPTY;
        }

        StringBuilder htmlForm = new StringBuilder();

         htmlForm.append("<form action=\"").append(eticketHtmlForm.url()).append("\" method=\"").append(eticketHtmlForm.httpMethod()).append("\">\n");
        htmlForm.append( "<div class=\"formContainer\">\n");


        Field[] fields = model.getDeclaredFields();

        for (Field field : fields) {

            if (!field.isAnnotationPresent(EticketFormField.class))
                continue;

            EticketFormField formField = field.getDeclaredAnnotation(EticketFormField.class);

            String fieldName = field.getName();

            htmlForm.append( "<div class=\"formInput\">\n");
            htmlForm.append("<label for=\"").append(StringUtils.isBlank(formField.labelFor()) ? fieldName : formField.labelFor()).append("\">").append(StringUtils.isBlank(formField.label()) ? fieldName : formField.label()).append("</label>\n");

            if (field.getType().isEnum()) {
                htmlForm.append("<select class=\"fixtureStyling\"")
                        .append(" id=\"").append(fieldName)
                        .append("\" name=\"").append(fieldName).append("\" ")
                        .append(">");


                for (Object enumValue : field.getType().getEnumConstants()) {
                    System.out.println(enumValue);

                    try {
                        Method method = field.getType().getMethod("getName");
                        htmlForm.append("htmlForm.append(<option value=\"")
                                .append(enumValue).append("\">")
                                .append(method.invoke(enumValue)).append("</option>)");
                    } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                        throw new RuntimeException(e);
                    }
                }
                htmlForm.append("</select>");
            } else{
            htmlForm.append(" <input type=\"").append(StringUtils.isBlank(formField.fieldType()) ? fieldName : formField.fieldType()).append("\" name=\"").append(StringUtils.isBlank(formField.name()) ? fieldName : formField.name()).append("\" id=\"").append(StringUtils.isBlank(formField.id()) ? fieldName : formField.id()).append("\" />\n");
            htmlForm.append( " </div>");

        }}
        ;

        htmlForm.append("</div>\n");
        htmlForm.append("<input class=\"normalFormButton\" type=\"submit\" value=\"Post Fixture\" />\n");
        htmlForm.append( "</form>");


        return htmlForm.toString();
    }



    public static String ticketForm(Class<?> model) {
        EticketHtmlForm eticketHtmlForm = null;
        if (model.isAnnotationPresent(EticketHtmlForm.class)) {
            eticketHtmlForm = model.getAnnotation(EticketHtmlForm.class);
        }
        if (eticketHtmlForm == null) {
            return StringUtils.EMPTY;
        }
        StringBuilder htmlForm = new StringBuilder();
         htmlForm.append("<form action=\"").append(eticketHtmlForm.url()).append("\" method=\"").append(eticketHtmlForm.httpMethod()).append("\">\n");
        htmlForm.append( " <p class=\"bookTicketTitle\">Book a ticket</p>\n");
        htmlForm.append( "<div class=\"formTicketContainer\">\n");

        Field[] fields = model.getDeclaredFields();


        for (Field field : fields) {
            if (!field.isAnnotationPresent(EticketFormField.class))
                continue;

            EticketFormField formField = field.getDeclaredAnnotation(EticketFormField.class);
            String fieldName = field.getName();
            htmlForm.append("<div class=\"formInput\">\n");
            htmlForm.append("<label for=\"").append(StringUtils.isBlank(formField.labelFor()) ? fieldName : formField.labelFor()).append("\">").append(StringUtils.isBlank(formField.label()) ? fieldName : formField.label()).append("</label>\n");

            if (field.getType().isEnum()) {
                htmlForm.append("<select class=\"fixtureStyling\"")
                        .append(" id=\"").append(fieldName)
                        .append("\" name=\"").append(fieldName).append("\" ")
                        .append(">");


                for (Object enumValue : field.getType().getEnumConstants()) {
                    System.out.println(enumValue);

                    try {
                        Method method = field.getType().getMethod("getName");
                        htmlForm.append("htmlForm.append(<option value=\"")
                                .append(enumValue).append("\">")
                                .append(method.invoke(enumValue)).append("</option>)");
                    } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                        throw new RuntimeException(e);
                    }
                }
                htmlForm.append("</select>");

            }else {

                htmlForm.append(" <input type=\"").append(StringUtils.isBlank(formField.fieldType()) ? fieldName : formField.fieldType()).append("\" name=\"").append(StringUtils.isBlank(formField.name()) ? fieldName : formField.name()).append("\" id=\"").append(StringUtils.isBlank(formField.id()) ? fieldName : formField.id()).append("\" />\n");
                htmlForm.append(" </div>");
            }
        }
        ;

        htmlForm.append( "</div>\n");
        htmlForm.append( " <div class=\"ticketButtons\">\n" +
                "<a href=\"./fixtures\" class=\"homeOutlineButton\" > Cancel</a>\n" +
                "<input class=\"normalFormButton\" type=\"submit\" value=\"Book Ticket\" />\n" +
                "</div>");

        htmlForm.append(" </form>\n");

        return htmlForm.toString();


    }
}
