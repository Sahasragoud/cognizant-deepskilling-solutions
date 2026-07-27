import React from 'react';

// Main Player List Component
export function ListofPlayers({ players }) {
  return (
    <div>
      <ul>
        {players.map((item, index) => (
          <div key={index}>
            <li>
              Mr. {item.name} <span>{item.score}</span>
            </li>
          </div>
        ))}
      </ul>
    </div>
  );
}

// Score Below 70 Component
export function Scorebelow70({ players }) {
  const players70 = [];
  
  players.map((item) => {
    if (item.score <= 70) {
      players70.push(item);
    }
    return item;
  });

  return (
    <div>
      <ul>
        {players70.map((item, index) => (
          <div key={index}>
            <li>
              Mr. {item.name} <span>{item.score}</span>
            </li>
          </div>
        ))}
      </ul>
    </div>
  );
}