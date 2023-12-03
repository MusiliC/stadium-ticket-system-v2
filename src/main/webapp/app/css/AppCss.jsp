 <style>
                 * {
                 margin: 0;
                 padding: 0;
                 box-sizing: border-box;
               }
               body{
                   width: 100%;
                   font-family: "Mona Sans", "Helvetica Neue", Helvetica, Arial, sans-serif;
                   font-size: 14px;
               }
               .navbarContainer{
                   width: 83%;
                   margin: auto;
                  padding: 30px 0px;
               }
               .title{
                   font-size: 1.2rem;

               }
               .title a{
                    color:  rgb(0, 53, 133);
                    text-decoration: none;
                    font-weight: 600;
                }
                .navClass{
                    display: flex;
                    justify-content: space-between;
                    width: 100%;
                    align-items: center;
                }
                .links{
                    display: flex;
                    gap: 40px;

                }
                .links,a{
                    color: #272829;
                    text-decoration: none;

                }
                .links a:hover{
                    color:  rgb(0, 53, 133);

                }
                .contactButton{
                    border:1px rgb(0, 53, 133) solid;
                    padding: 8px 17px;
                    border-radius: 25px;
                    color: rgb(0, 53, 133);
                }
                .contactButton a{
                    text-decoration: none;
                    color: <%= request.getParameter("buttonColor") %>;
                }
                .contactButton a:hover{
                    color: white;
                }
                .contactButton:hover{
                    /* border:none; */
                    background-color: rgb(10, 79, 182) ;
                    color: white;
                    cursor: pointer;
                }
            .lastPart{
                    display: flex;
                    align-items: center;
                    gap: 30px;
                }
                .profile{
                    padding: 12px 15px;
                    border-radius: 50%;
                    border:none;
                    background-color: rgb(10, 79, 182) ;
                    color: white;
                    font-weight: 600;
                }
            <%--home styling --%>
            .mainContainer {
                  width: 83%;
                  margin: auto;
                  padding-top: 10px;
                  padding-bottom: 10px;
                  display: flex;
                  justify-content: space-around;
                  height: 83vh;
                  align-items: center;
                  gap: 30px;
                }
                .heroSection {
                  width: 50%;
                  display: flex;
                  flex-direction: column;
                  gap: 20px;
                }
                .sectionTitle {
                  font-size: 2.7rem;
                  font-weight: 600;
                  letter-spacing: 2px;
                  line-height: 4rem;

                }
                .summary {
                  width: 70%;
                  color: #272829;
                  margin: 13px 0px;

                }
                .blueText {
                  color: rgb(0, 53, 133);
                }
                .homeNormalButton{
                    padding: 12px 24px;
                    border-radius: 25px;
                    border:none;
                    background-color: rgb(10, 79, 182) ;
                    color: white;
                    cursor: pointer;
                    text-decoration: none;
                }
                .homeOutlineButton{
                    border:1px rgb(0, 53, 133) solid;
                    padding: 10px 20px;
                    border-radius: 25px;
                    color: rgb(0, 53, 133);
                    text-decoration: none;
                }
                .homeOutlineButton:hover{
                    /* border:none; */
                    background-color: rgb(10, 79, 182) ;
                    color: white;
                    cursor: pointer;
                }
                .homeButtons{
                    display: flex;
                    gap: 20px;
                    align-items: center;
                }
                .heroImage {
                  width: 50%;
                }
                .imageContainer{
                  width: 100%;

                }
                .bgImage{
                  width: 100%;
                }
             .formMainContainer {
                  width: 83%;
                  margin: auto;
                  padding-top: 10px;
                  padding-bottom: 10px;
                  display:flex;
                  flex-direction: column;
                  justify-content: center;
                  align-items: center;

                }
                .formContainer {
                  width: 600px;
                  display: grid;
                  grid-template-columns: auto auto;
                  gap: 15px;
                  margin: 20px 0px;
                }

                .formSubmitButton{
                   display:flex;
                   flex-direction: column;
                   justify-content: center;
                   align-items: center;
                }

                .normalFormButton {
                  padding: 12px 24px;
                  border-radius: 25px;
                  border: none;
                  background-color: rgb(10, 79, 182);
                  color: white;
                  cursor: pointer;
                }
                .formInput {
                  display: flex;
                  flex-direction: column;
                  gap: 5px;
                  margin: 5px 0px;
                }
                .formInput input {
                  padding: 10px;
                  border-radius: 3px;
                  border: 1px solid lightgray;
                }
                .formInput input:focus {
                  outline: none;
                }
             .fixtureStyling{
                  padding: 10px;
                  border-radius: 3px;
                  border: 1px solid lightgray;
                }
                .fixtureStyling:focus{
                  outline: none;
                }

              .fixtureContainer {
                  width: 83%;
                  min-height: 50vh;
                  margin: auto;
                  padding-top: 10px;
                  padding-bottom: 10px;
                }
                .fixtureAdminContainer {
                                  width: 100%;
                                  margin: auto;
                                  padding-top: 10px;
                                  padding-bottom: 10px;
                                }
                .outlineTicketButton{
                    border:1px rgb(0, 53, 133) solid;
                    padding: 10px 20px;
                    border-radius: 25px;
                    color: rgb(0, 53, 133);
                }
                .outlineTicketButton:hover{
                    background-color: rgb(10, 79, 182) ;
                    color: white;
                    cursor: pointer;
                }
               .outlineTicketButton a{
                  text-decoration: none;
                  color: rgb(0, 53, 133);
                }
            .outlineTicketButton a:hover{
                  text-decoration: none;
                  color: white;
                }
                .topPart {
                  height: 150px;
                  background: rgb(28, 85, 172);
                  margin-bottom: 30px;
                  display: flex;
                  align-items: center;
                }
                .topPartTitle{
                    width: 83%;
                    margin: auto;
                }
                .topPartTitle p{
                    color: white;
                    font-size: 1.5rem;
                    font-weight: 600;
                    font-style: italic;
                }

                .oneFixture {
                  display: flex;
                  justify-content: space-between;
                  width: 100%;
                  align-items: center;
                  padding: 18px 0px;
                  color: #272829;
                  border-bottom: 1px solid #7c7c7c;
                }
                .oneFixture:hover {
                  cursor: pointer;
                  background-color: rgb(238, 238, 238);
                  padding: 18px 5px;
                  color: black;
                }
                .teams, .timeLocation {
                  display: flex;
                  flex-direction: column;
                  gap: 7px;
                }
                .fixture{
                 width: 200px;
                }
                 .timeLocation, .teams{
                  width: 150px;
                 }


            <%--ticket styling --%>
             .mainTicketContainer {
                  width: 83%;
                  margin: auto;
                  padding-top: 30px;
                  padding-bottom: 30px;
                  display: flex;
                  justify-content: space-around;
                  flex-wrap: wrap;
                  align-items: center;
                  height: 100%;
                }
              .topTicketPart {
                  height: 150px;
                  background: rgb(28, 85, 172);
                  margin-bottom: 10px;
                  display: flex;
                  align-items: center;
                }
                .topTicketPartTitle{
                    width: 83%;
                    margin: auto;
                }
                .topTicketPartTitle p{
                    color: white;
                    font-size: 1.5rem;
                    font-weight: 600;
                    font-style: italic;
                }
                .fixtureCard{
                    box-shadow: 0 0 5px rgba(0, 0, 0, 0.4);
                    padding: 35px;
                    display: flex;
                    flex-direction: column;
                    gap: 25px;
                    align-items: center;
                }
                .fixtureCard p{
                    text-align: center;
                }
             .fixtureCard:hover{
                    background-color: #E0F4FF;
                    cursor: pointer;
                }
                .ticketInfoDetails{
                    display: flex;
                    flex-direction: column;
                    gap: 10px;
                    text-align: center;
                    font-weight: 600;
                }
                .myTicketNormalButton{
              padding: 12px 0px;
                    text-align: center;
                    border-radius: 25px;
                    width:170px;
                    border:none;
                    background-color: rgb(10, 79, 182) ;
                    color: white;
                    cursor: pointer;
                    text-decoration: none;
                }
                .myTicketNormalButton a{
                    text-decoration: none;
                    color: white;
                }
            <%--ticketBook --%>
              .mainTicketBookContainer{
                  display: flex;
                  justify-content: center;
                  align-items: center;
                  height: 70vh;
                }

                .formTicketBookContainer {
                  width: 600px;
                  display: grid;
                  grid-template-columns: auto auto;
                  gap: 15px;
                  margin: 20px 0px;
                }
              .fixtureTitle {
                  font-size: 1.5rem;
                  text-align: center;
                  margin: 20px 0px;
                  color: rgb(10, 79, 182);
                }
                .bookTicketTitle{
                 font-size: 1.5rem;
                                  text-align: center;
                                  margin: 20px 0px;
                                  color: rgb(10, 79, 182);
                }
              .bookTicketButtons{
                     display: flex;
                     justify-content: space-between;
                     gap: 20px;
                     align-items: center;
                }
            <%--oneTicket styling --%>

             .ticketBodyContainer {
                  width: 100%;
                  height: 90vh;
                  display: flex;
                  flex-direction: column;
                  justify-content: center;
                  align-items: center;
                }

                .mainOneTicketContainer {
                  width: 700px;
                  padding: 20px;
                  border-radius: 5px;
                  box-shadow: 0 0 5px rgba(0, 0, 0, 0.4);
                }
                .topOneTicketPart {
                  display: flex;
                  align-items: center;
                  justify-content: space-around;
                }
                }
                .gameStyling {
                  display: flex;
                  justify-content: center;
                  align-items: center;
                  padding: 10px;
                  font-size: 1.1rem;
                }
                .fixtureType {
                  display: flex;
                  flex-direction: column;
                  gap: 12px;
                  text-align: center;
                  font-weight: 600;
                }
                .fineTicketDetails {
                  display: flex;
                  justify-content: space-between;
                  align-items: center;
                  margin-top: 10px;
                  padding: 10px;
                }
                .fineTicketDetails .leftPart,
                .rightPart {
                  display: flex;
                  flex-direction: column;
                  gap: 12px;
                  text-align: start;
                }
                .ticketNormalButton {
                  padding: 12px 24px;
                  border-radius: 25px;
                  border: none;
                  background-color: rgb(10, 79, 182);
                  color: white;
                  cursor: pointer;
                  text-decoration: none;
                }
                .ticketOutlineButton {
                  border: 1px rgb(0, 53, 133) solid;
                  padding: 10px 20px;
                  border-radius: 25px;
                  color: rgb(0, 53, 133);
                  text-decoration: none;
                }
                .ticketOutlineButton:hover {
                  background-color: rgb(10, 79, 182);
                  color: white;
                  cursor: pointer;
                }
                .ticketButtons {
                  display: flex;
                  margin-top: 30px;
                  gap: 20px;
                  align-items: center;
                }
                .ticketDetailsTitle{
                  margin-bottom: 30px;
                }
                 .ticketDetailsTitle p{
                      font-size: 1.7rem;
                      letter-spacing: 2px;
                      color: rgb(10, 79, 182);
                      font-weight: 570;
                    }

                     .oneTicketButtons {
                          display: flex;
                          margin-top: 30px;
                          gap: 20px;
                          align-items: center;
                        }
            <%-- footer --%>
             .footerContainer{
                    width: 100%;
                    padding: 25px;
                    border-top: 1px solid black;
                    margin-top: 60px;
                }
                .rightsClass{
                    text-align: center;
                    font-size: 1.1rem;
                    display: flex;
                    gap: 10px;
                    align-items: center;
                    justify-content: center;
                }
                .rightsClass a{
                    text-decoration: none;
                    color: rgb(10, 79, 182);
                    font-weight: 600;
                }
                   .adminMainContainer{
                        display: flex;
                        width: 100%;
                        min-height: 100vh;
                    }
                    .sidebar{
                        width: 20%;
                        background-color: rgb(10, 79, 182);
                        color: white;
                        display: flex;
                        flex-direction: column;

                    }
                    .adminContent{
                      height: 100%;
                        width: 80%;
                    }
                    .adminAppName{
                        padding: 40px 30px;
                        border-bottom: 1px solid wheat;
                        display: flex;
                        align-items: center;
                        gap: 10px;
                    }

                    .adminAppName p{
                        font-size: 1.3rem;
                        font-weight: 600;
                    }

                    .adminTitle{
                        padding: 30px 30px;
                        border-bottom: 1px solid wheat;
                        display: flex;
                        align-items: center;
                        gap: 10px;

                    }
                    .adminTitle p {
                        font-size: 1.1rem;
                        font-weight: 600;
                    }

                    .adminLinks{
                        display: flex;
                        flex-direction: column;
                        gap: 30px;
                        padding: 40px 30px;
                        border-bottom: 1px solid wheat;
                    }

                    .adminLinkTag{
                        display: flex;
                        align-items: center;
                        gap: 10px;
                    }

                    .adminLinkTag a{
                        color: white;
                        text-decoration: none;
                    }

                    .adminSettings{
                        padding: 40px 30px;
                        display: flex;
                        align-items: center;
                        gap: 10px;
                    }
                    .topAdminPart{
                        display: flex;
                        width: 80%;
                        margin: 10px auto;
                        padding: 20px 0px;
                        justify-content: space-between;
                        align-items: center;
                    }
                       .topAdminPart a{
                          color: #272829;
                          text-decoration: none;
                        }
                        .topAdminPart a:hover {
                          color: rgb(0, 53, 133);
                        }

                  .adminLogout {
                       border: 1px rgb(0, 53, 133) solid;
                       padding: 7px 15px;
                       border-radius: 25px;
                       color: rgb(0, 53, 133);
                     }

                     .adminLogout:hover{
                         background-color: rgb(0, 53, 133);
                         color: white;
                     }
                     .adminLogout a:hover{
                         color: white;
                     }
                       .bottomAdminPart{
                           width: 100%;

                           padding: 10px;
                           display: flex;
                           justify-content: center;
                           align-items: center;
                         }

                          <%-- Admin ticket report styling --%>

                        .adminTableContainer {
                               width: 60%;
                               margin: 20px auto;
                             }
                             table {
                               border-collapse: collapse;
                               width: 100%;
                             }
                             th {
                               color: rgb(10, 79, 182);
                             }

                             td,
                             th {
                               border: 1px solid #dddddd;
                               text-align: left;
                               padding: 12px;
                             }
                             .fixtureTitleTable {
                               font-size: 1.5rem;
                               color: rgb(10, 79, 182);
                               margin-bottom: 20px;
                               text-align: center;
                             }

                             tr:nth-child(even) {
                               background-color: #dddddd;
                             }
                             .ticketReportOneButton {
                               padding: 12px 24px;
                               border-radius: 25px;
                               border: none;
                               background-color: rgb(10, 79, 182);
                               color: white;
                               cursor: pointer;
                               text-decoration: none;
                             }
                             .ticketReportButton {
                               display: flex;
                               margin-top: 30px;
                               gap: 20px;
                               align-items: center;
                               justify-content: center;
                             }
                             <%-- user admin styling --%>
                              .userOutlineButton {
                                     border: 1px rgb(0, 53, 133) solid;
                                     width: 80px;
                                     display: flex;
                                     align-items: center;
                                     justify-content: center;
                                     padding: 5px 0px;
                                     border-radius: 25px;
                                     color: rgb(0, 53, 133);
                                     text-decoration: none;
                                   }
                                   .userOutlineButton:hover {
                                     /* border:none; */
                                     background-color: rgb(10, 79, 182);
                                     color: white;
                                     cursor: pointer;
                                   }
                                   .TicketPricingContainer {
                                       width: 83%;
                                       margin: auto;
                                       padding-top: 10px;
                                       padding-bottom: 10px;
                                       width: 700px;
                                     }
                                     .formTicketContainer {
                                      margin: 20px 0px;
                                     }
                                     .formTicketInput {
                                          display: flex;
                                          flex-direction: column;
                                          gap: 5px;
                                          margin: 5px 0px;
                                        }
                                        .formTicketInput input {
                                          padding: 10px;
                                          border-radius: 3px;
                                          border: 1px solid lightgray;
                                        }
                                        .formTicketInput input:focus {
                                          outline: none;
                                        }
                                          .ticketPriceItems{
                                              margin: 40px 0px;
                                            }
                                            .ticketPriceTitle{
                                              font-size: 1.5rem;
                                              color: rgb(10, 79, 182);
                                              text-align: center;
                                              margin: 10px 0px;
                                            }
                                            .tablePricing{
                                                    margin: 20px 0px;
                                                  }

                                <%-- book ticket --%>
                                   .ticketNumber,.newTicketInfoDetails,.ticketDate{
                                        width: 150px;
                                    }
                                    .ticketFixtureType{
                                        width: 200px;
                                    }
                                    .myTicketNormalButton{
                                        width: 100px;
                                    }

                                    .newTicketContainer {
                                        width: 100%;
                                        margin: auto;
                                        padding-top: 20px;
                                        padding-bottom: 20px;
                                    }

                                    .newTicketCard {
                                        box-shadow: 0 0 3px rgba(0, 0, 0, 0.4);
                                        padding: 17px;
                                        margin-top: 20px;
                                        margin-bottom: 20px;
                                        display: flex;
                                        gap: 25px;
                                        align-items: center;
                                        justify-content: space-between;
                                    }

                                    .newTicketCard:hover {
                                        background-color: #E0F4FF;
                                        cursor: pointer;
                                    }

                                    .newTicketInfoDetails {
                                        display: flex;
                                        flex-direction: column;
                                        gap: 10px;
                                        text-align: start;
                                        font-weight: 500;
                                    }

                            </style>