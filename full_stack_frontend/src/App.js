
import './App.css';
import Home from './Home';
import StudentsView from './Components/Students/StudentsView';
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import "/node_modules/bootstrap/dist/js/bootstrap.min.js";
import NavBar from './Components/Comman/NavBar';
import StudentPofile from './Components/Students/StudentPofile';
import {
	BrowserRouter as Router,
	Routes,
	Route,
} from "react-router-dom";
import AddStudent from './Components/Students/AddStudent';
import EditStudent from './Components/Students/EditStudents';



function App() {
  return (
    <main className="container mt-5">
			<Router>
				<NavBar />
				<Routes>
					<Route
						exact
						path="/"
						element={<Home />}></Route>
					<Route
						exact
						path="/view-students"
						element={<StudentsView />}></Route>
					<Route
						exact
						path="/add-students"
						element={<AddStudent />}></Route>
					<Route
						exact
						path="/edit-student/:id"
						element={<EditStudent />}></Route>
					<Route
						exact
						path="/student-profile/:id"
						element={<StudentPofile />}></Route>
				</Routes>
			</Router>
		</main>
  );
}

export default App;
