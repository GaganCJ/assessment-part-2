import React, { Component } from 'react';
import { Button, Row, Col, Form, InputGroup } from 'react-bootstrap';
import './login.css';
import { Formik } from 'formik';

export class Login extends Component {
    render() {
        return (
            <Row>
                <Col xs={4} className="sidenav">
                    <h2>
                        Assessment Management<br /> Login Page
                    </h2>
                    <p>Login and Register for Assessment.</p>
                </Col>
                <Col xs={8} className="login-form">
                    <Formik initialValues={{ userId: "", password: "", level: "0" }}
                        onSubmit={(values, { setSubmitting, resetForm }) => {
                            setSubmitting(true);
                            setTimeout(() => {
                                alert(JSON.stringify(values, null, 2));
                                resetForm();
                                setSubmitting(false);
                            }, 2000);
                        }}
                    >
                        {({ values, errors, touched, handleChange, handleBlur, handleSubmit, isSubmitting }) => (
                            <Form className="form-horizontal" onSubmit={handleSubmit}>
                                <InputGroup className="mb-3">
                                    <InputGroup.Text>User ID</InputGroup.Text>
                                    <Form.Control
                                        id="userId"
                                        name="userId"
                                        type="text"
                                        placeholder="User ID"
                                        onChange={handleChange}
                                        onBlur={handleBlur}
                                        value={values.userId}
                                        required
                                    />
                                </InputGroup>
                                <InputGroup className="mb-3">
                                    <InputGroup.Text>Password</InputGroup.Text>
                                    <Form.Control
                                        id="password"
                                        name="password"
                                        type="password"
                                        placeholder="Password"
                                        onChange={handleChange}
                                        onBlur={handleBlur}
                                        value={values.password}
                                        required
                                    />
                                </InputGroup>
                                <InputGroup className="mb-3">
                                    <InputGroup.Text>User Level</InputGroup.Text>
                                    <Form.Select name="level" id="level"
                                        onChange={handleChange}
                                        onBlur={handleBlur}
                                        value={values.level}>
                                        <option value="0" disabled>
                                            Select a Level
                                        </option>
                                        <option value="1">Employee</option>
                                        <option value="2">Admin</option>
                                    </Form.Select>
                                </InputGroup>
                                <Button type="submit" variant="dark" disabled={isSubmitting} onClick={!isSubmitting}>
                                    {isSubmitting ? 'Logging In...' : 'Login'}
                                </Button>
                            </Form>)}
                    </Formik>
                    <div className="alert mt-3" role="alert">
                        <strong>{/*{ errAlert.eUserId }*/}</strong>
                        <strong>{/*{ errAlert.ePass }*/}</strong>
                        <strong>{/*{ errAlert.eLevel }*/}</strong>
                    </div>
                </Col>
            </Row>
        );
    }
}

export default Login;
