using Livet;
using Mntone.UniversitySchedule.Client.Demo.Core;
using Mntone.UniversitySchedule.Core;

namespace Mntone.UniversitySchedule.Client.Demo.ViewModels
{
	public sealed class MainWindowViewModel
		: ViewModel
	{
		private readonly UnivScheduleAppContext _context;

		public MainWindowViewModel()
		{
			this._context = UnivScheduleAppContext.Context;
		}

		public async void Initialize()
		{
			var univs = await this._context.GetUniverstiesAsync();
			foreach( var univ in univs.Universities )
			{
				this._Universties.Add( univ );
			}
		}

		public async void LoadNewClass( string screenName )
		{
			var classes = await this._context.GetClassesAsync( screenName );
			this._Classes.Clear();
			foreach( var klass in classes.Classes )
			{
				this._Classes.Add( klass );
			}
		}

		public ObservableSynchronizedCollection<University> Universties
		{
			get { return this._Universties; }
		}
		private readonly ObservableSynchronizedCollection<University> _Universties = new ObservableSynchronizedCollection<University>();

		public University SelectedUniversity
		{
			get { return this._SelectedUniversity; }
			set
			{
				if( this._SelectedUniversity != value )
				{
					this._SelectedUniversity = value;
					this.RaisePropertyChanged();

					this.LoadNewClass( this._SelectedUniversity.ScreenName );
				}
			}
		}
		private University _SelectedUniversity = null;

		public ObservableSynchronizedCollection<Class> Classes
		{
			get { return this._Classes; }
		}
		private readonly ObservableSynchronizedCollection<Class> _Classes = new ObservableSynchronizedCollection<Class>();

		public Class SelectedClass
		{
			get { return this._SelectedClass; }
			set
			{
				if( this._SelectedClass != value )
				{
					this._SelectedClass = value;
					this.RaisePropertyChanged();
				}
			}
		}
		private Class _SelectedClass = null;
	}
}