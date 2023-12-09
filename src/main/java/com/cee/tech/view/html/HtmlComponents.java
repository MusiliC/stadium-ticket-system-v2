package com.cee.tech.view.html;

import com.cee.tech.app.model.entity.Fixture;
import com.cee.tech.database.MySqlDatabase;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.EJB;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HtmlComponents implements Serializable {
    public static String table(Class<?> clazz, List<?> models) {


        Field[] fields = clazz.getDeclaredFields();

        StringBuilder tbBuilder = new StringBuilder();

        tbBuilder.append("<table>");

        tbBuilder.append("<tr>");

        for (Field field : fields) {
            if (!field.isAnnotationPresent(EticketTableColHeader.class))
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
                if (!field.isAnnotationPresent(EticketTableColHeader.class))
                    continue;
                field.setAccessible(true);
                try {
                    tbBuilder.append("<td ><a href=\"example.html\">").append(field.get(model)).append("</a></td>");

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
        htmlForm.append("<div class=\"formContainer\">\n");

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
                htmlForm.append(" </div>");
            } else {
                htmlForm.append(" <input type=\"").append(StringUtils.isBlank(formField.fieldType()) ? fieldName : formField.fieldType()).append("\" name=\"").append(StringUtils.isBlank(formField.name()) ? fieldName : formField.name()).append("\" id=\"").append(StringUtils.isBlank(formField.id()) ? fieldName : formField.id()).append("\" />\n");
                htmlForm.append(" </div>");

            }
        }
        ;

        htmlForm.append("</div>\n");
        htmlForm.append("<div class=\"formSubmitButton\">\n");
        htmlForm.append("<input class=\"normalFormButton\" type=\"submit\" value=\"Submit\" />\n");
        htmlForm.append(" </div>");
        htmlForm.append("</form>");


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
        htmlForm.append("<div class=\"mainTicketBookContainer\"> ");
        htmlForm.append("<form action=\"").append(eticketHtmlForm.url()).append("\" method=\"").append(eticketHtmlForm.httpMethod()).append("\">\n");
        htmlForm.append(" <p class=\"bookTicketTitle\">Book a ticket</p>\n");
        htmlForm.append("<div class=\"formTicketBookContainer\">\n");

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

            } else {

                htmlForm.append(" <input type=\"").append(StringUtils.isBlank(formField.fieldType()) ? fieldName : formField.fieldType()).append("\" name=\"").append(StringUtils.isBlank(formField.name()) ? fieldName : formField.name()).append("\" id=\"").append(StringUtils.isBlank(formField.id()) ? fieldName : formField.id()).append("\" />\n");

            }
            htmlForm.append(" </div>");
        }
        ;

        htmlForm.append("</div>\n");
        htmlForm.append(" <div class=\"bookTicketButtons\">\n" +
                "<a href=\"./fixtures\" class=\"homeOutlineButton\" > Cancel</a>\n" +
                "<input class=\"normalFormButton\" type=\"submit\" value=\"Book Ticket\" />\n" +
                "</div>");

        htmlForm.append(" </form>\n");

        htmlForm.append(" </div>");

        return htmlForm.toString();

    }

    public static String fixtureCard(Class<?> clazz, List<?> models) throws IllegalAccessException, NoSuchFieldException {
        Field[] fields = clazz.getDeclaredFields();

        StringBuilder cardBuilder = new StringBuilder();

        if (models != null && !models.isEmpty()) {
            for (Object model : models) {
                cardBuilder.append("<div class=\"oneFixture\">");

                for (Field field : fields) {
                    if (!field.isAnnotationPresent(EticketFixtureCard.class))
                        continue;

                    field.setAccessible(true);
                    EticketFixtureCard annotation = field.getAnnotation(EticketFixtureCard.class);

                    if ("fixtureTime".equals(field.getName())) {
                        cardBuilder.append("<div class=\"").append(annotation.cssClass()).append("\">");
                        // Append the homeTeam field to awayTeam
                        cardBuilder.append("<p>").append(field.get(model) + " EAT").append("</p>");

                        Field fixtureLocation = model.getClass().getDeclaredField("fixtureLocation");
                        fixtureLocation.setAccessible(true);
                        cardBuilder.append("<p>").append(fixtureLocation.get(model)).append("</p>");
                        cardBuilder.append("</div>");
                    } else if ("homeTeam".equals(field.getName())) {
                        cardBuilder.append("<div class=\"").append(annotation.cssClass()).append("\">");
                        // Append the homeTeam field to awayTeam
                        cardBuilder.append("<p>").append(field.get(model)).append("</p>");

                        Field awayTeamField = model.getClass().getDeclaredField("awayTeam");
                        awayTeamField.setAccessible(true);
                        cardBuilder.append("<p>").append(awayTeamField.get(model)).append("</p>");
                        cardBuilder.append("</div>");
                    } else {
                        if ("fixtureLocation".equals(field.getName()))
                            continue;
                        if ("awayTeam".equals(field.getName()))
                            continue;
                        cardBuilder.append("<div class=\"").append(annotation.cssClass()).append("\">");

                        // For other fields, append them normally
                        cardBuilder.append("<p>").append(field.get(model)).append("</p>");
                        cardBuilder.append("</div>");
                    }
                }

                cardBuilder.append("<div class=\"ticket\">");
                cardBuilder.append(" <div class=\"outlineTicketButton\"><a href=\"./book\">Buy Ticket</a> </div>");
                cardBuilder.append("</div>");

                //closing div for one fixture container
                cardBuilder.append("</div>");
            }
        }


        return cardBuilder.toString();
    }


    public static String bookTicketCard(Class<?> clazz, List<?> models) throws IllegalAccessException, NoSuchFieldException {

        Field[] fields = clazz.getDeclaredFields();

        StringBuilder cardBuilder = new StringBuilder();

        cardBuilder.append("<div class=\"topTicketPart\">\n" +
                "        <div class=\"topTicketPartTitle\">\n" +
                "          <p>My Tickets</p>\n" +
                "        </div>\n" +
                "      </div>\n");

        cardBuilder.append("<div class=\"mainTicketContainer\">\n");

        cardBuilder.append("<div class=\"newTicketContainer\">");

        if (models != null && !models.isEmpty()) {
            for (Object model : models) {
                cardBuilder.append("<div class=\"newTicketCard\">");

                for (Field field : fields) {
                    if (!field.isAnnotationPresent(EticketHtmlCard.class))
                        continue;

                    field.setAccessible(true);
                    EticketHtmlCard annotation = field.getAnnotation(EticketHtmlCard.class);


                    if ("homeTeam".equals(field.getName())) {
                        cardBuilder.append("<div class=\"").append(annotation.cssClass()).append("\">");
                        // Append the homeTeam field to awayTeam
                        cardBuilder.append("<p>").append(field.get(model)).append("</p>");

                        Field awayTeamField = model.getClass().getDeclaredField("awayTeam");
                        awayTeamField.setAccessible(true);
                        cardBuilder.append("<p>").append(awayTeamField.get(model)).append("</p>");
                        cardBuilder.append("</div>");
                    } else {
                        if ("awayTeam".equals(field.getName()))
                            continue;
                        cardBuilder.append("<div class=\"").append(annotation.cssClass()).append("\">");

                        // For other fields, append them normally
                        cardBuilder.append("<p>").append(field.get(model)).append("</p>");
                        cardBuilder.append("</div>");
                    }
                }

                cardBuilder.append("<div class=\"myTicketNormalButton\">");
                cardBuilder.append("<a href=\"./ticketdetails").append("\">View</a>");
                cardBuilder.append("</div>");

                cardBuilder.append("</div>");
            }
        }

        cardBuilder.append("</div>");
        cardBuilder.append("</div>");


        return cardBuilder.toString();
    }


}
