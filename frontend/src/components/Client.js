import React, { useState } from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import { Container, Paper, Button } from '@mui/material';

export default function Client() {
    const paperStyle = { padding: "50px 20px", width: 600, margin: "20px auto" };
    const [name, setName] = useState('');
    const [issue, setIssue] = useState('');

    const handleClick = (e) => {
        e.preventDefault();
        const client = { name, issue };
        console.log(client);
        addClient(client);
    };

    const addClient = (client) => {
        fetch('http://localhost:1010/client/add', {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(client)
        })
        .then(response => response.json())
        .then(data => {
            console.log("New Issue added:", data);
            // Optionally, you can clear the input fields after submitting
            setName('');
            setIssue('');
        })
        .catch(error => console.error('Error adding issue:', error));
    };

    return (
        <Container>
            <Paper elevation={3} style={paperStyle}>
                <h1 style={{ color: "blue" }}>Add Issue</h1>
                <Box
                    component="form"
                    sx={{
                        '& > :not(style)': { m: 1 },
                    }}
                    noValidate
                    autoComplete="off"
                >
                    <TextField
                        id="outlined-basic"
                        label="Client Name"
                        variant="outlined"
                        fullWidth
                        value={name}
                        onChange={(e) => setName(e.target.value)}
                    />
                    <TextField
                        id="outlined-basic"
                        label="Client Issue"
                        variant="outlined"
                        fullWidth
                        value={issue}
                        onChange={(e) => setIssue(e.target.value)}
                    />
                    <Button variant="contained" onClick={handleClick}>Submit</Button>
                </Box>
            </Paper>
        </Container>
    );
}
