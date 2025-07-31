const API_URL = "http://localhost:8080/api/movies";

async function loadMovies() {
  const response = await fetch(API_URL);
  const movies = await response.json();

  const container = document.getElementById("movie-container");
  container.innerHTML = ""; 

  movies.forEach(movie => {
    const card = document.createElement("div");
    card.className = "card";
    card.innerHTML = `
      <img src="${movie.posterUrl}" alt="${movie.title}" />
      <h2>${movie.title}</h2>
      <p><strong>Director:</strong> ${movie.director}</p>
      <p><strong>Year:</strong> ${movie.releaseYear}</p>
      <p><strong>Genre:</strong> ${movie.genre}</p>
      <p><strong>Rating:</strong> ⭐ ${movie.imdbRating}</p>
    `;
    container.appendChild(card);
  });
}

loadMovies();
