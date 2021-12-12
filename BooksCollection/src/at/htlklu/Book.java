package at.htlklu;

public class Book implements Comparable<Book>{

	private String author, title, issue;
	
	public Book(String author, String title, String issue) {
		this.author = author;
		this.title = title;
		this.issue = issue;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	@Override
	public int compareTo(Book o) {
		return this.getTitle().compareTo(o.getTitle());
	}

	@Override
	public String toString() {
		return "Book [author=" + author + ", title=" + title + ", issue=" + issue + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((issue == null) ? 0 : issue.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (issue == null) {
			if (other.issue != null)
				return false;
		} else if (!issue.equals(other.issue))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
}
