<%@include file="taglib.jsp"%>

<div class="col-md-10 text-left">
    <br>
    <h2>${updateMsg}</h2>
    <p align="right">
    <c:choose>
        <c:when test="${personType == 'Staff'}">
            <a href="search-person?searchTerm=&searchType=viewAll">Go to List of Staff</a>
        </c:when>
        <c:when test="${personType == 'Client'}">
            <a href="search-person?searchTerm=&searchType=viewAll">Go to List of Clients</a>
        </c:when>
    </c:choose>
    </p>

    <c:choose>
        <c:when test="${personType == 'Client'}">
            <form class="form-horizontal" action="update-client?idClient=${updateClientId}" method="POST" id="reg_form">
        </c:when>
        <c:when test="${personType == 'Staff'}">
            <form class="form-horizontal" action="update-staff?idStaff=${updateStaffId}" method="POST" id="reg_form">
        </c:when>
    </c:choose>

            <c:choose>
                <c:when test="${updatedAlready == 'No'}">
                    <fieldset>
                </c:when>
                <c:otherwise>
                    <fieldset disabled>
                </c:otherwise>
            </c:choose>

                <!-- Form Name -->
                <legend class="text-center"> Personal Information </legend>

                <!-- firstName Text input-->

                <div class="form-group">
                    <label class="col-md-4 control-label">First Name</label>
                    <div class="col-md-6  inputGroupContainer">
                        <div class="input-group"> <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <input  name="firstName" value="${updtFirstName}" class="form-control"  type="text">
                        </div>
                    </div>
                </div>

                <!-- lastName Text input-->

                <div class="form-group">
                    <label class="col-md-4 control-label" >Last Name</label>
                    <div class="col-md-6  inputGroupContainer">
                        <div class="input-group"> <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <input name="lastName" value="${updtLastName}" class="form-control"  type="text">
                        </div>
                    </div>
                </div>

                <!-- birthDate Text input-->

                <div class="form-group">
                    <label class="col-md-4 control-label" >Date of Birth</label>
                    <div class="col-md-6  inputGroupContainer">
                        <div class="input-group date"> <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
                            <input name="birthDt" value="${updtBirthDt}" class="form-control"  type="text">
                        </div>
                    </div>
                </div>

                <!-- phoneNr - Text input-->

                <div class="form-group">
                    <label class="col-md-4 control-label">Phone #</label>
                    <div class="col-md-6  inputGroupContainer">
                        <div class="input-group"> <span class="input-group-addon"><i class="glyphicon glyphicon-earphone"></i></span>
                            <input name="phoneNr" value="${updtPhoneNr}" class="form-control" type="text">
                        </div>
                    </div>
                </div>

                <!-- email - Text input-->

                <div class="form-group">
                    <label class="col-md-4 control-label">E-Mail</label>
                    <div class="col-md-6  inputGroupContainer">
                        <div class="input-group"> <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
                            <input name="email" value="${updtEmail}" class="form-control"  type="text">
                        </div>
                    </div>
                </div>

                <c:choose>
                    <c:when test="${personType == 'Client'}">

                        <!-- billCd - Select Basic -->

                        <div class="form-group">
                            <label class="col-md-4 control-label">Bill Code</label>
                            <div class="col-md-6 selectContainer">
                                <div class="input-group"> <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
                                    <select name="billCd" class="form-control selectpicker" >
                                        <option value="${updtBillCd}">${updtBillCd}</option>
                                        <c:forEach var="clientRateCode" items="${clientRateCodeValueMap}">
                                            <option>${clientRateCode.getKey()}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                        </div>
                    </c:when>

                    <c:when test="${personType == 'Staff'}">

                        <!-- jobTitle - Text input-->

                        <div class="form-group">
                            <label class="col-md-4 control-label">Job Title</label>
                            <div class="col-md-6  inputGroupContainer">
                                <div class="input-group"> <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                    <input  name="jobTitle" value="${updtJobTitle}" class="form-control"  type="text">
                                </div>
                            </div>
                        </div>

                        <!-- payCd - Select Basic -->

                        <div class="form-group">
                            <label class="col-md-4 control-label">Pay Code</label>
                            <div class="col-md-6 selectContainer">
                                <div class="input-group"> <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
                                    <select name="payCd" class="form-control selectpicker" >
                                        <option value="${updtPayCd}" >${updtPayCd}</option>
                                        <c:forEach var="staffRateCode" items="${staffRateCodeValueMap}">
                                            <option>${staffRateCode.getKey()}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                        </div>
                    </c:when>
                </c:choose>


                <!-- Text input-->

                <div class="form-group">
                    <label class="col-md-4 control-label">Street Address</label>
                    <div class="col-md-6  inputGroupContainer">
                        <div class="input-group"> <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
                            <input name="street" value="${updtStreet}" class="form-control" type="text">
                        </div>
                    </div>
                </div>

                <!-- Text input-->

                <div class="form-group">
                    <label class="col-md-4 control-label">City</label>
                    <div class="col-md-6  inputGroupContainer">
                        <div class="input-group"> <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
                            <input name="city" value="${updtCity}" class="form-control"  type="text">
                        </div>
                    </div>
                </div>


                <!-- Select Basic -->

                <div class="form-group">
                    <label class="col-md-4 control-label">State</label>
                    <div class="col-md-6 selectContainer">
                        <div class="input-group"> <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
                            <select name="state" class="form-control selectpicker" >
                                <option value="${updtState}">${updtState}</option>
                                <option>AL</option>
                                <option>AK</option>
                                <option>AZ</option>
                                <option>AR</option>
                                <option>CA</option>
                                <option>CO</option>
                                <option>CT</option>
                                <option>DE</option>
                                <option>DC</option>
                                <option>FL</option>
                                <option>GA</option>
                                <option>HI</option>
                                <option>ID</option>
                                <option>IL</option>
                                <option>IN</option>
                                <option>IA</option>
                                <option>KS</option>
                                <option>KY</option>
                                <option>LA</option>
                                <option>ME</option>
                                <option>MD</option>
                                <option>MA</option>
                                <option>MI</option>
                                <option>MN</option>
                                <option>MS</option>
                                <option>MO</option>
                                <option>MT</option>
                                <option>NE</option>
                                <option>NV</option>
                                <option>NH</option>
                                <option>NJ</option>
                                <option>NM</option>
                                <option>NY</option>
                                <option>NC</option>
                                <option>ND</option>
                                <option>OH</option>
                                <option>OK</option>
                                <option>OR</option>
                                <option>PA</option>
                                <option>RI</option>
                                <option>SC</option>
                                <option>SD</option>
                                <option>TN</option>
                                <option>TX</option>
                                <option>UT</option>
                                <option>VT</option>
                                <option>VA</option>
                                <option>WA</option>
                                <option>WV</option>
                                <option>WI</option>
                                <option>WY</option>
                            </select>
                        </div>
                    </div>
                </div>

                <!-- Text input-->

                <div class="form-group">
                    <label class="col-md-4 control-label">Zip Code</label>
                    <div class="col-md-6  inputGroupContainer">
                        <div class="input-group"> <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
                            <input name="zipcode" value="${updtZipcode}" class="form-control"  type="text">
                        </div>
                    </div>
                </div>


                <!-- Text input-->

                <c:if test="${personType == 'Staff'}">
                    <div class="form-group">
                        <label class="col-md-4 control-label">Schedule</label>
                        <div class="col-md-6  inputGroupContainer">
                            <div class="input-group"> <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
                                <input  name="schedule" value="${updtSchedule}" class="form-control"  type="text">
                            </div>
                        </div>
                    </div>
                </c:if>


                <!-- Button -->

                <div class="form-group">
                    <label class="col-md-4 control-label"></label>
                    <div class="col-md-4">
                        <button type="submit" class="btn btn-primary">Update
                            <span class="glyphicon glyphicon-ok"></span></button> &nbsp;
                        <a href="search-person?searchTerm=&searchType=viewAll" class="btn btn-primary">Cancel
                            <span class="glyphicon glyphicon-remove"></span></a>
                    </div>
                </div>

            </fieldset>
        </form>


        <script type="text/javascript">

            $(document).ready(function() {
                $('#reg_form').bootstrapValidator({
                    // To use feedback icons, ensure that you use Bootstrap v3.1.0 or later
                    feedbackIcons: {
                        valid: 'glyphicon glyphicon-ok',
                        invalid: 'glyphicon glyphicon-remove',
                        validating: 'glyphicon glyphicon-refresh'
                    },
                    fields: {
                        firstName: {
                            validators: {
                                stringLength: {
                                    min: 2
                                },
                                notEmpty: {
                                    message: 'Please supply a first name'
                                }
                            }
                        },
                        lastName: {
                            validators: {
                                stringLength: {
                                    min: 2
                                },
                                notEmpty: {
                                    message: 'Please supply a last name'
                                }
                            }
                        },
                        birthDt: {
                            validators: {
                                date: {
                                    format: 'YYYY/MM/DD',
                                    message: 'Please supply a valid birth date'
                                },
                                notEmpty: {
                                    message: 'Please supply a valid birth date in YYYY/MM/DD or YYYY-MM-DD format'
                                }
                            }
                        },
                        phoneNr: {
                            validators: {
                                notEmpty: {
                                    message: 'Please supply your phone number'
                                },
                                phone: {
                                    country: 'US',
                                    message: 'Please supply a vaild phone number with area code'
                                }
                            }
                        },
                        email: {
                            validators: {
                                notEmpty: {
                                    message: 'Please supply an email address'
                                },
                                emailAddress: {
                                    message: 'Please supply a valid email address'
                                }
                            }
                        },
                        billCd: {
                            validators: {
                                notEmpty: {
                                    message: 'Please select a client bill code'
                                }
                            }
                        },
                        jobTitle: {
                            validators: {
                                stringLength: {
                                    min: 2
                                },
                                notEmpty: {
                                    message: 'Please supply a job title'
                                }
                            }
                        },
                        payCd: {
                            validators: {
                                notEmpty: {
                                    message: 'Please select a staff pay code'
                                }
                            }
                        },
                        street: {
                            validators: {
                                stringLength: {
                                    min: 4
                                },
                                notEmpty: {
                                    message: 'Please supply a street address'
                                }
                            }
                        },
                        city: {
                            validators: {
                                stringLength: {
                                    min: 4
                                },
                                notEmpty: {
                                    message: 'Please supply a city'
                                }
                            }
                        },
                        state: {
                            validators: {
                                notEmpty: {
                                    message: 'Please select a state'
                                }
                            }
                        },
                        zipcode: {
                            validators: {
                                notEmpty: {
                                    message: 'Please supply a zip code'
                                },
                                zipCode: {
                                    country: 'US',
                                    message: 'Please supply a vaild zip code'
                                }
                            }
                        }

                    }
                })

                    .on('success.form.bv', function(e) {
                        $('#success_message').slideDown({ opacity: "show" }, "slow") // Do something ...
                        $('#reg_form').data('bootstrapValidator').resetForm();

                        // Prevent form submission
                        e.preventDefault();

                        // Get the form instance
                        var $form = $(e.target);

                        // Get the BootstrapValidator instance
                        var bv = $form.data('bootstrapValidator');

                        // Use Ajax to submit form data
                        $.post($form.attr('action'), $form.serialize(), function(result) {
                            console.log(result);
                        }, 'json');
                    });
            });

        </script>

        <p align="right">
        <c:choose>
            <c:when test="${personType == 'Staff'}">
                <a href="search-person?searchTerm=&searchType=viewAll">Go to List of Staff</a>
            </c:when>
            <c:when test="${personType == 'Client'}">
                <a href="search-person?searchTerm=&searchType=viewAll">Go to List of Clients</a>
            </c:when>
        </c:choose>
        </p>
        <br>
</div>
